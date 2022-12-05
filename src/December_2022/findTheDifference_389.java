package December_2022;

/*
    给定两个字符串 s 和 t, 它们只包含小写字母.
    字符串 t 由字符串 s 随机重排, 然后在随机位置添加一个字母.
    请找出在 t 中被添加的字母.
 */
public class findTheDifference_389 {
    public char findTheDifference(String s, String t) {
        int res = 0;
        for(char c : t.toCharArray()){
            res += (int)c;
        }
        for(char c : s.toCharArray()){
            res -= (int)c;
        }
        return (char)res;
    }
}
