package November_2021;

import java.util.HashMap;

/*
    给你一个整数数组 arr 和一个整数 difference, 请你找出并返回 arr 中最长等差子序列的长度,
    该子序列中相邻元素之间的差等于 difference .
    子序列是指在不改变其余元素顺序的情况下, 通过删除一些元素或不删除任何元素而从 arr 派生出来的序列 .
 */

public class longestSubsequence {
    public int longestSubsequence(int[] arr, int difference) {
        if(arr.length <= 1)
            return arr.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int res = 0;
        for(int num : arr){
            map.put(num, map.getOrDefault(num - difference, 0) + 1);
            res = Math.max(res, map.get(num));
        }
        return res;
    }
}
