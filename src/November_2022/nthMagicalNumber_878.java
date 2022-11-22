package November_2022;

/*
    一个正整数如果能被 a 或 b 整除, 那么它是神奇的.
    给定三个整数 n, a, b, 返回第 n 个神奇的数字.
    因为答案可能很大, 所以返回答案对 10^9 + 7 取模后的值.
 */
public class nthMagicalNumber_878 {
    private static int MOD = 1000000007;
    public int nthMagicalNumber(int n, int a, int b) {
        //二分查找
        long left = Math.min(a, b);
        long right = (long) n * Math.min(a, b);
        int c = (a * b) / gcd(a, b);
        while(left < right){
            long mid = left + (right - left) / 2;
            //设 f(x) 为小于等于 x 的「神奇数字」个数
            // c 为 a 和 b的最小公倍数
            //f(x) = (a / x) + (b / x) - (c / x)
            long cnt = mid / a + mid / b - mid / c;
            if(cnt >= n){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return (int)(right % MOD);
    }

    public int gcd(int a, int b){
        return b != 0 ? gcd(b, a % b) : a;
    }
}
