package October_2021;

/*
    给定两个整数，被除数 dividend 和除数 divisor. 将两数相除, 要求不使用乘法 除法 和 mod 运算符.

    返回被除数 dividend 除以除数 divisor 得到的商。

    整数除法的结果应当截去(truncate)其小数部分, 例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2.
 */

public class divide_29 {
    public int divide(int dividend, int divisor) {
        if(dividend == 0)
            return 0;
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        boolean signed;
        signed = (dividend ^ divisor) < 0;
        long m = Math.abs((long) dividend);
        long n = Math.abs((long) divisor);
        int res = 0;
        for(int i = 31; i >= 0; i--){
            if((m >> i) >= n){
                res += (1 << i);
                m -= (n << i);
            }
        }
        return signed ? -res : res;
    }
}
