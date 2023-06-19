package June_2023;

import java.util.ArrayList;
import java.util.Collections;
/*
    给你一个整数数组 nums, 请你找出并返回能被三整除的元素最大和.
 */
public class maxSumDivThree_1262 {
    //贪心算法：目前是 3 整除可用，当规模越大（ 4 整除、5 整除）时就显得吃力了
    public int maxSumDivThree(int[] nums) {
        int sum = 0, res = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 3 == 0){
            return sum;
        }
        var a1 = new ArrayList<Integer>();
        var a2 = new ArrayList<Integer>();
        for(int num : nums){
            if(num % 3 == 1){
                a1.add(num);
            }else if(num % 3 == 2){
                a2.add(num);
            }
        }
        Collections.sort(a1);
        Collections.sort(a2);
        if(sum % 3 == 2){
            var temp = a1;
            a1 = a2;
            a2 = temp;
        }
        res = a1.isEmpty() ? 0 : sum - a1.get(0);
        if(a2.size() > 1){
            res = Math.max(res, sum - a2.get(0) - a2.get(1));
        }
        return res;
    }

    //动态规划：记忆化搜索 + 递推
    public int maxSumDivThree2(int[] nums) {
        int n = nums.length;
        var f = new int[n + 1][3];
        f[0][1] = f[0][2] = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 3; j++){
                // j 表示除 3 取余的数
                f[i + 1][j] = Math.max(f[i][j], f[i][(j + nums[i]) % 3] + nums[i]);
            }
        }
        return f[n][0];
    }
}
