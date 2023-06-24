package June_2023;

import java.util.Arrays;
/*
    给定整数 n, 返回所有小于非负整数 n 的质数的数量.
 */
public class countPrimes_204 {
    //埃氏筛：如果 x 是质数, 那么大于 x 的 x 的倍数 2x, 3x,...一定不是质数
    public int countPrimes(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int res = 0;
        for(int i = 2; i < n; i++){
            if(isPrime[i] == 1){
                res += 1;
                //对于一个质数 x, 从 2x 开始标记是冗余的, 2的倍数已被标记过, 因此从 x * x 开始.
                if((long) i * i < n){
                    for(int j = i * i; j < n; j += i){
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return res;
    }
}
