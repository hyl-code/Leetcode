package January_2024;

/*
    给你一个字符串 s 和一个整数 repeatLimit, 用 s 中的字符构造一个新字符串 repeatLimitedString,
    使任何字母连续出现的次数都不超过 repeatLimit 次. 你不必使用 s 中的全部字符.
    返回字典序最大的 repeatLimitedString.
    如果在字符串 a 和 b 不同的第一个位置, 字符串 a 中的字母在字母表中出现时间比字符串 b 对应的字母晚, 则认为字符串 a 比字符串 b 字典序更大.
    如果字符串中前 min(a.length, b.length) 个字符都相同，那么较长的字符串字典序更大.
 */
public class repeatLimitedString_2182 {
    public static int N = 26;

    public String repeatLimitedString(String s, int repeatLimit) {
        int[] cnt = new int[N];
        for(int i = 0; i < s.length(); i++){
            cnt[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int m = 0;
        for(int i = N - 1, j = N - 2; i >= 0 && j >= 0; ){
            if(cnt[i] == 0){
                m = 0;
                i--;
            }else if(m < repeatLimit){
                cnt[i]--;
                sb.append((char)('a' + i));
                m++;
            }else if(j >= i || cnt[j] == 0){
                j--;
            }else{
                cnt[j]--;
                sb.append((char)('a' + j));
                m = 0;
            }
        }
        return sb.toString();
    }
}
