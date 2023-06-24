package June_2023;

/*
    给你两个正整数 a 和 b, 返回 a 和 b 的公因子的数目.
    如果 x 可以同时整除 a 和 b, 则认为 x 是 a 和 b 的一个公因子.
 */
public class commonFactors_2427 {
    public int commonFactors(int a, int b) {
        int res = 0, g = gcd(a, b);
        for(int i = 1; i * i <= g; i++){
            //成对出现, 当 i * i != g 时, [g / i] 也符合条件.
            if(g % i == 0){
                res++;
                if(i * i < g){
                    res++;
                }
            }
        }
        return res;
    }

    //欧几里得算法
    public int gcd(int a, int b){
        while(a != 0){
            int temp = a;
            a = b % a;
            b = temp;
        }
        return b;
    }
}
