package November_2022;

/*
    有两种形状的瓷砖: 一种是 2 x 1 的多米诺形, 另一种是形如 "L" 的托米诺形. 两种形状都可以旋转.
    给定整数 n, 返回可以平铺 2 x n 的面板的方法的数量. 返回对 10^9 + 7 取模的值.
    平铺指的是每个正方形都必须有瓷砖覆盖.
    两个平铺不同, 当且仅当面板上有四个方向上的相邻单元中的两个, 使得恰好有一个平铺有一个瓷砖占据两个正方形.
 */
public class numTilings_790 {
    static int MOD = 1000000007;
    public int numTilings(int n) {
        if(n <= 2){
            return n;
        }
        //找规律会发现: f(n) = f[n - 1] + f[n - 2] + 2 * (f[n - 3] + ... + 1)
        // f[n] - f[n - 1] 得 f[n] - f[n - 1] = f[n - 1] + f[n - 3]
        //所以, f[n] = 2 * f[n - 1] + f[n - 3]
        long[] f = new long[n + 1];
        f[0] = f[1] = 1;
        f[2] = 2;
        for(int i = 3; i <= n; i++){
            f[i] = (f[i - 1] * 2 + f[i - 3]) % MOD;
        }
        return (int) f[n];
    }
}
