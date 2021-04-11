package April_2021;

    //263.给你一个整数n，请你判断n是否为丑数。 如果是，返回 true；否则，返回false。

        //丑数就是只包含质因数2，3 和/或5的正整数。

public class Ugly_NumberI {
    public boolean isUgly(int n) {

        if(n < 1){
            return false;
        }

        while(n % 5 == 0){
            n /= 5;
        }

        while(n % 3 == 0){
            n /= 3;
        }

        while(n % 2 == 0){
            n /= 2;
        }

        if(n == 1)
            return true;
        else
            return false;
    }
}
