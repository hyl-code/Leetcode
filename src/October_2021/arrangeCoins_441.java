package October_2021;

/*
    你总共有 n 枚硬币, 并计划将它们按阶梯状排列.
    对于一个由 k 行组成的阶梯, 其第 i 行必须正好有 i 枚硬币.
    阶梯的最后一行可能是不完整的.
    给你一个数字 n ,计算并返回可形成完整阶梯行的总行数.
 */

public class arrangeCoins_441 {
    public int arrangeCoins(int n) {
        int res = 0;
        for(int i = 1; n >= i; i++){
            n -= i;
            res++;
        }
        return res;
    }
}
