package June_2023;

import java.util.Arrays;
/*
    给你一个长度为 n 、下标从 1 开始的二进制字符串, 所有位最开始都是 0.
    我们会按步翻转该二进制字符串的所有位（即，将 0 变为 1）.
    给你一个下标从 1 开始的整数数组 flips, 其中 flips[i] 表示对应下标 i 的位将会在第 i 步翻转.
    二进制字符串前缀一致需满足：在第 i 步之后, 在闭区间 [1, i] 内的所有位都是 1, 而其他位都是 0.
    返回二进制字符串在翻转过程中前缀一致的次数.
 */
public class numTimesAllBlue_1375 {
    //没理解题意的暴力解法 QAQ
    public int numTimesAllBlue(int[] flips) {
        int res = 0, n = flips.length;
        int num = 0;
        int[] b = new int[n];
        Arrays.fill(b, 0);
        for(int i = 0; i < n; i++){
            int index = flips[i];
            b[index - 1] ^= 1;
            if(isValid(b, i)){
                res++;
            }
        }
        return res;
    }

    public boolean isValid(int[] b, int index){
        for(int i = 0; i <= index; i++){
            if(b[i] == 0){
                return false;
            }
        }
        return true;
    }

    public int numTimesAllBlue2(int[] flips) {
        int res = 0, n = flips.length;
        int far = 0;
        for(int i = 0; i < n; i++){
            //维护最远的翻转点
            far = Math.max(far, flips[i]);
            //如果最远翻转点 = i + 1, 则说明前 i + 1 个已被翻转
            if(i + 1 == far){
                res++;
            }
        }
        return res;
    }
}
