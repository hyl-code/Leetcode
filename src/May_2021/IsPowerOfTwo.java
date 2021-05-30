package May_2021;

//给你一个整数 n,请你判断该整数是否是 2 的幂次方.如果是,返回 true ;否则,返回 false .

//如果存在一个整数 x 使得n == 2^x ,则认为 n 是 2 的幂次方.


public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {

        if(n < 0 || n == 0){
            return false;
        }else if(n == 1){
            return true;
        }else if(n % 2 != 0){
            return false;
        }

        return isPowerOfTwo(n / 2);
    }
}
