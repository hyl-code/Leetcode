package April_2022;

/*
    给你一个 m x n 的整数网格 accounts, 其中 accounts[i][j] 是第 i 位客户在第 j 家银行托管的资产数量.
    返回最富有客户所拥有的 资产总量 .
    客户的 资产总量 就是他们在各家银行托管的资产数量之和.
    最富有客户就是 资产总量 最大的客户.
 */

public class maximumWealth_1672 {
    public int maximumWealth(int[][] accounts) {
        int res = 0;
        for(int i = 0; i < accounts.length;i++){
            int sum = 0;
            for(int j = 0; j < accounts[i].length; j++){
                sum += accounts[i][j];
            }
            res = Math.max(res, sum);
            sum = 0;
        }
        return res;
    }
}
