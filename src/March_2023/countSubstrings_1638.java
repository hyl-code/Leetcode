package March_2023;

/*
    给你两个字符串 s 和 t, 请你找出 s 中的非空子串的数目, 这些子串满足替换一个不同字符以后, 是 t 串的子串.
    换言之, 请你找到 s 和 t 串中恰好只有一个字符不同的子字符串对的数目.
    比方说, "computer" and "computation" 只有一个字符不同: 'e'/'a', 所以这一对子字符串会给答案加 1 .
    请你返回满足上述条件的不同子字符串对数目.
    一个 子字符串是一个字符串中连续的字符.
 */
public class countSubstrings_1638 {
    //枚举
    public int countSubstrings(String s, String t) {
        int res = 0;
        int m = s.length(), n = t.length();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int diff = 0;
                for(int k = 0; (i + k) < m && (j + k) < n; k++){
                    if(s.charAt(i + k) != t.charAt(j + k)){
                        diff++;
                    }
                    if(diff > 1){
                        break;
                    }else if(diff == 1){
                        res++;
                    }
                }
            }
        }
        return res;
    }

    //预处理 + 动态规划
    public int countSubstrings2(String s, String t) {
        int res = 0;
        int m = s.length(), n = t.length();
        int[][] dpl = new int[m + 1][n + 1];    //以某点起, 左侧连续相等子串最大长度
        int[][] dpr = new int[m + 1][n + 1];    //以某点起, 右侧连续相等子串最大长度
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dpl[i + 1][j + 1] = s.charAt(i) == t.charAt(j) ? (dpl[i][j] + 1) : 0;
            }
        }
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                dpr[i][j] = s.charAt(i) == t.charAt(j) ? (dpr[i + 1][j + 1] + 1) : 0;
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(s.charAt(i) != t.charAt(j)){
                    res += (dpl[i][j] + 1) * (dpr[i + 1][j + 1] + 1);
                }
            }
        }
        return res;
    }
}
