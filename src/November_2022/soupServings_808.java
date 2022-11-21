package November_2022;

/*
    有 A 和 B 两种类型的汤. 一开始每种类型的汤有 n 毫升. 有四种分配操作:
        提供 100ml 的汤 A 和 0ml 的汤 B.
        提供 75ml 的汤 A 和 25ml 的汤 B.
        提供 50ml 的汤 A 和 50ml 的汤 B.
        提供 25ml 的汤 A 和 75ml 的汤 B.
    当我们把汤分配给某人之后, 汤就没有了. 每个回合, 我们将从四种概率同为 0.25 的操作中进行分配选择.
    如果汤的剩余量不足以完成某次操作, 我们将尽可能分配. 当两种类型的汤都分配完时, 停止操作.
    注意: 不存在先分配 100 ml 汤 B 的操作.
    需要返回的值: 汤 A 先分配完的概率 + 汤 A和汤 B 同时分配完的概率 / 2.
    返回值在正确答案 10^(-5) 的范围内将被认为是正确的.
 */
public class soupServings_808 {
    public double soupServings(int n) {
        //答案在 4800 后就一直是 1
        if(n > 4800){
            return 1;
        }
        if(n == 0){
            return 0.5;
        }
        //不存在小数份数, 所以要向上取整
        n = (n - 1) / 25 + 1;
        double[][] res = new double[n + 1][n + 1];
        res[0][0] = 0.5;
        for(int i = 1; i <= n; i++){
            res[0][i] = 1;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                //全概率公式
                res[i][j] = (res[Math.max(i - 4, 0)][j] + res[Math.max(i - 3, 0)][j - 1] + res[Math.max(i - 2, 0)][Math.max(j - 2, 0)] + res[i - 1][Math.max(j - 3, 0)]) / 4;
            }
        }
        return res[n][n];
    }
}
