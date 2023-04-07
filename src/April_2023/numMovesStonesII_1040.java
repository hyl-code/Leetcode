package April_2023;

import java.util.Arrays;

public class numMovesStonesII_1040 {
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int n = stones.length;
        int s1 = stones[n - 2] - stones[0] - n + 2;
        int s2 = stones[n - 1] - stones[1] - n + 2; //计算空位
        int maxMove = Math.max(s1, s2);
        if(s1 == 0 || s2 == 0){ // 特殊情况: 没有空位
            return new int[] {Math.min(2, maxMove), maxMove};
        }
        int maxCnt = 0, left = 0;
        //最小移动次数为 n - 窗口内的最大石子数
        for(int right = 0; right < n; right++){ //滑动窗口
            while(stones[right] - stones[left] + 1 > n){    //窗口大小小于 n 时
                left++;
            }
            maxCnt = Math.max(maxCnt, right - left + 1);    //确认窗口内的最大石子数
        }
        return new int[] {n - maxCnt, maxMove};
    }
}
