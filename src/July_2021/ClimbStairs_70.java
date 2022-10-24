package July_2021;

/*
    假设你正在爬楼梯. 需要 n 阶你才能到达楼顶.
    每次你可以爬 1 或 2 个台阶.
    你有多少种不同的方法可以爬到楼顶呢?
    注意:给定 n 是一个正整数.
 */

public class ClimbStairs_70 {
    public int climbStairs(int n) {
        if(n <= 2)
            return n;
        int a = 1, b = 2, temp;
        //第 n 个台阶只能从第 n - 1 或者 n - 2 个上来.
        //到第 n - 1 个台阶的走法 + 第 n - 2 个台阶的走法 = 到第 n 个台阶的走法
        for(int i = 3; i <= n; i++){
            temp = a + b;
            a = b;
            b = temp;
        }//滚动数组
        return b;
    }
}
