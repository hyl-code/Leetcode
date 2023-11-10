package November_2023;

import java.util.Arrays;
/*
    给你两个正整数数组 spells 和 potions, 长度分别为 n 和 m, 其中 spells[i] 表示第 i 个咒语的能量强度, potions[j] 表示第 j 瓶药水的能量强度.
    同时给你一个整数 success. 一个咒语和药水的能量强度相乘如果大于等于 success, 那么它们视为一对成功的组合.
    请你返回一个长度为 n 的整数数组 pairs, 其中 pairs[i] 是能跟第 i 个咒语成功组合的药水数目.
 */
public class successfulPairs_2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] res = new int[spells.length];
        for(int i = 0; i < spells.length; i++){
            int left = 0, right = potions.length - 1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                long t = (success + spells[i] - 1) / spells[i] - 1;
                if(potions[mid] > t){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            res[i] = potions.length - left;
        }
        return res;
    }
}
