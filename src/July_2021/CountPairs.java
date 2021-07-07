package July_2021;

//大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
//
//你可以搭配 任意 两道餐品做一顿大餐。
//
//给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第i道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。
//结果需要对 109 + 7 取余。
//注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。


import java.util.HashMap;
import java.util.Map;

public class CountPairs {
    //哈希表
    public int countPairs(int[] deliciousness) {
        final int MOD = 1000000007;
        int maxVal = 0;
        for (int val : deliciousness) {
            maxVal = Math.max(maxVal, val);
        }
        int maxSum = maxVal * 2;
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = deliciousness.length;
        for (int i = 0; i < n; i++) {
            int val = deliciousness[i];
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                int count = map.getOrDefault(sum - val, 0);
                pairs = (pairs + count) % MOD;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return pairs;
    }

    //暴力解法 无了
    public int countPairs2(int[] deliciousness) {
        int sum;
        int count = 0;

        for(int i = 0; i < deliciousness.length - 1; i++){
            for(int j = i + 1; j < deliciousness.length; j++){
                sum = deliciousness[i] + deliciousness[j];
                while(sum >= 2 && sum % 2 == 0)
                    sum /= 2;
                if(sum == 1)
                    count++;
            }
        }
        return count;
    }
}
