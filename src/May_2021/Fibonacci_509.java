package May_2021;

//斐波那契数,通常用F(n)表示,形成的序列称为斐波那契数列.该数列由0和1开始,后面的每一项数字都是前面两项数字的和.也就是:
//F(0) = 0,F(1)= 1
//F(n) = F(n - 1) + F(n - 2),其中 n > 1
//给你 n ，请计算 F(n) 。

public class Fibonacci_509 {
    public int fib(int n) {
        int Fib;
        if(n == 1 || n == 2){
            Fib = 1;
        }
        else if(n == 0){
            Fib = 0;
        }
        else{
            Fib = fib(n - 1) + fib(n - 2);
        }
        return Fib;
    }// 递归
}
