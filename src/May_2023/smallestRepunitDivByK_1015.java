package May_2023;

import java.util.HashSet;
import java.util.Set;

/*
    给定正整数 k, 你需要找出可以被 k 整除的、仅包含数字 1 的最小正整数 n 的长度.
    返回 n 的长度. 如果不存在这样的 n, 就返回-1.
    注意: n 不符合 64 位带符号整数.
 */

public class smallestRepunitDivByK_1015 {
    //用 Hash 表存放余数, 当有重复余数时, 无法整除, 返回 -1.
    public int smallestRepunitDivByK(int k) {
        Set<Integer> set = new HashSet<>();
        int num = 1 % k;
        while(num > 0 && set.add(num)){
            num = (num * 10 + 1) % k;
        }
        return num > 0 ? -1 : set.size() + 1;
    }

    // n 的个位数是 1, 显然不是 2 和 5 的倍数.
    // 如果 k 是 2 和 5 的倍数, 那么必然无解; 否则必然有解.
    public int smallestRepunitDivByK2(int k) {
        if(k % 2 == 0 || k % 5 == 0){
            return -1;
        }
        int num = 1 % k;
        for(int i = 1; ; i++){          // 一定有解
            if(num == 0){
                return i;
            }
            num = (num * 10 + 1) % k;
        }
    }
}
