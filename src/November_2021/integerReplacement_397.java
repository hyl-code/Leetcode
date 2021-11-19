package November_2021;

/*
    给定一个正整数 n , 你可以做如下操作:
    如果 n 偶数，则用 n / 2替换 n .
    如果 n 是奇数，则可以用 n + 1或n - 1替换 n .
    n 变为 1 所需的最小替换次数是多少 ?
 */

public class integerReplacement_397 {
    public int integerReplacement(int n) {
        int res = 0;
        while(n != 1){
            if(n % 2 == 0){
                n >>= 1;
                res++;
            }else if(n % 4 == 1){
                res += 2;
                n /= 2;
            }else{
                if(n == 3){
                    res += 2;
                    n = 1;
                }else{
                    res += 2;
                    n = n / 2 + 1;
                }
            }
        }
        return res;
    }
}
