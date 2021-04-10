package April_2021;

    //7.给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。

    //如果反转后整数超过 32 位的有符号整数的范围[−2^31,2^31 − 1]，就返回 0。


public class Integer_Reverse {
    public int reverse(int x) {
        long n = 0;

        while(x != 0){
            n = n *10 + x % 10;
            x = x / 10;
        }

        if((int)n != n)
            n = 0;


        return (int)n;
    }
}
