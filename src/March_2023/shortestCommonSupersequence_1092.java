package March_2023;

/*
    给出两个字符串 str1 和 str2, 返回同时以 str1 和 str2 作为子序列的最短字符串.
    如果答案不止一个, 则可以返回满足条件的任意一个答案.
    (如果从字符串 T 中删除一些字符(也可能不删除, 并且选出的这些字符可以位于 T 中的任意位置),
    可以得到字符串 S, 那么 S 就是 T 的子序列)
 */
public class shortestCommonSupersequence_1092 {
    // LCS求解
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }else{
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        StringBuilder res = new StringBuilder();
        int i = m, j = n;
        while(i > 0 && j > 0){
            if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                res.append(str1.charAt(i - 1));
                i--;
                j--;
            }else if(dp[i][j] == dp[i - 1][j]){
                res.append(str1.charAt(i - 1));
                i--;
            }else if(dp[i][j] == dp[i][j - 1]){
                res.append(str2.charAt(j - 1));
                j--;
            }
        }
        while(i > 0){
            res.append(str1.charAt(--i));
        }
        while(j > 0){
            res.append(str2.charAt(--j));
        }
        return res.reverse().toString();
    }
}
