package April_2022;

/*
    给你两个整数 left 和 right, 在闭区间 [left, right] 范围内, 统计并返回 计算置位位数为质数 的整数个数 .
    计算置位位数 就是二进制表示中 1 的个数 .
        例如, 21 的二进制表示 10101 有 3 个计算置位 .
 */

public class isPrime_762 {
    public int countPrimeSetBits(int left, int right) {
        int res = 0;
        for(int i = left; i <= right; i++){
            if(isPrime(Integer.bitCount(i)))
                res++;
        }
        return res;
    }

    public boolean isPrime(int x){
        if(x < 2)
            return false;
        for(int i = 2; i <= x / i; i++){
            if(x % i == 0)
                return false;
        }
        return true;
    }
}
