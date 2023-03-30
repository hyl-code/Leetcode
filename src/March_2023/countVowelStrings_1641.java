package March_2023;

import java.util.Arrays;

/*
    给你一个整数 n, 请返回长度为 n , 仅由元音 (a, e, i, o, u) 组成且按字典序排列的字符串数量.
    字符串 s 按字典序排列需要满足:
        对于所有有效的 i, s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前.
 */
public class countVowelStrings_1641 {
    //dp[0]代表以 'a' 开头的组合, dp[1]代表以 'e' 开头的组合... (以此类推)
    public int countVowelStrings(int n) {
        int[] dp = {1, 1, 1, 1, 1};
        for(int i = 1; i < n; i++){
            dp[0] += dp[1] + dp[2] + dp[3] + dp[4];
            dp[1] += dp[2] + dp[3] + dp[4];
            dp[2] += dp[3] + dp[4];
            dp[3] += dp[4];
        }
        return dp[0] + dp[1] + dp[2] + dp[3] + dp[4];
    }

    // 看起来很专业, 与第一种方法同理
    public int countVowelStrings2(int n) {
        int[] dp = new int[5];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 5; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return Arrays.stream(dp).sum();
    }

    // 数学
    public int countVowelStrings3(int n) {
        return ((n + 4) * (n + 3) * (n + 2) * (n + 1)) / (2 * 3 * 4);
    }
}
