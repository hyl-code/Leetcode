package October_2022;

/*
    给你两个字符串 word1 和 word2.
    请你从 word1 开始, 通过交替添加字母来合并字符串.
    如果一个字符串比另一个字符串长, 就将多出来的字母追加到合并后字符串的末尾.
    返回合并后的字符串.
 */
public class mergeAlternately_1768 {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int m = word1.length();
        int n = word2.length();
        for(int i = 0; i < Math.min(m, n); i++){
            sb.append(word1.charAt(i)).append(word2.charAt(i));
        }
        if(m > n){
            sb.append(word1.substring(n, m));
        }else if(m < n){
            sb.append(word2.substring(m, n));
        }
        return sb.toString();
    }
}
