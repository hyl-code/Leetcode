package September_2023;

import java.util.Arrays;
/*
    给你两个单词 word1 和 word2, 请返回将 word1 转换成 word2 所使用的最少操作数.
    你可以对一个单词进行如下三种操作：
        插入一个字符
        删除一个字符
        替换一个字符
 */
public class minDistance_72 {
    private char[] s, t;
    private int[][] memo;

    public int minDistance(String word1, String word2) {
        s = word1.toCharArray();
        t = word2.toCharArray();
        int n = s.length, m = t.length;
        memo = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(memo[i], -1);
        }
        return dfs(n - 1, m - 1);
    }

    private int dfs(int i, int j){
        if(i < 0){
            return j + 1;
        }
        if(j < 0){
            return i + 1;
        }
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        if(s[i] == t[j]){
            return memo[i][j] = dfs(i - 1, j - 1);
        }
        return memo[i][j] = Math.min(Math.min(dfs(i - 1, j), dfs(i, j - 1)), dfs(i - 1, j - 1)) + 1;
    }
}
