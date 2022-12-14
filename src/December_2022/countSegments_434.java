package December_2022;

/*
    统计字符串中的单词个数, 这里的单词指的是连续的不是空格的字符.
    请注意, 你可以假定字符串里不包括任何不可打印的字符.
 */
public class countSegments_434 {
    public int countSegments(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            if((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' '){
                res++;
            }
        }
        return res;
    }
}
