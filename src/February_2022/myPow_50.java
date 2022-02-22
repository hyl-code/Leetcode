package February_2022;

/*
    实现 pow(x, n), 即计算 x 的 n 次幂函数 (即, xn ) .
 */

public class myPow_50 {
    public double myPow(double x, int n) {
        long num = n;
        return num >= 0 ? mul(x, num) : 1.0 / mul(x, -num);
    }

    public double mul(double x, long num){
        double res = 1.0;
        //对num进行二进制拆分的同时计算答案
        while(num > 0){
            if(num % 2 == 1){
                res *= x;
            }
            x *= x;
            num /= 2;
        }
        return res;
    }
}
