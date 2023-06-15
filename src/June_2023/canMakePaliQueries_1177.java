package June_2023;

import java.util.ArrayList;
import java.util.List;
/*
    给你一个字符串 s, 请你对 s 的子串进行检测.
    每次检测, 待检子串都可以表示为 queries[i] = [left, right, k].
    我们可以重新排列子串 s[left], ..., s[right] , 并从中选择最多 k 项替换成任何小写英文字母.
    如果在上述检测过程中, 子串可以变成回文形式的字符串, 那么检测结果为 true, 否则结果为 false.
    返回答案数组 answer[], 其中 answer[i] 是第 i 个待检子串 queries[i] 的检测结果.
    注意：在替换时, 子串中的每个字母都必须作为独立的项进行计数, 也就是说, 如果 s[left..right] = "aaa" 且 k = 2, 我们只能替换其中的两个字母.
    （另外, 任何检测都不会修改原始字符串 s, 可以认为每次检测都是独立的）
 */
public class canMakePaliQueries_1177 {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();
        int[][] preSum = new int[n + 1][26];
        //计算前缀和：preSum[i + 1][j] 表示从 s[0] 到 s[i] 中, 字母表第 j 个小写字母出现的次数.
        for(int i = 0; i < n; i++){
            preSum[i + 1] = preSum[i].clone();
            preSum[i + 1][s.charAt(i) - 'a']++;
        }
        List<Boolean> res = new ArrayList<>();
        for(var query : queries){
            int left = query[0], right = query[1], k = query[2], m = 0;
            for(int j = 0; j < 26; j++){
                //统计有多少个小写字母出现奇数次
                m += (preSum[right + 1][j] - preSum[left][j]) % 2;
            }
            res.add(m / 2 <= k);
        }
        return res;
    }
}
