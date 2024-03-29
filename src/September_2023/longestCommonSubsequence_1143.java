package September_2023;

/*
    给定两个字符串 text1 和 text2, 返回这两个字符串的最长公共子序列的长度. 如果不存在公共子序列, 返回 0.
    一个字符串的子序列是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串.
    例如, "ace" 是 "abcde" 的子序列, 但 "aec" 不是 "abcde" 的子序列.
    两个字符串的公共子序列是这两个字符串所共同拥有的子序列.
 */
public class longestCommonSubsequence_1143 {
    // 动态规划
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]), dp[i][j]);
            }
        }
        return dp[m][n];
    }
}
