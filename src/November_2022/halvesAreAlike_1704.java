package November_2022;

import java.util.ArrayList;
import java.util.List;

/*
    给你一个偶数长度的字符串 s. 将其拆分成长度相同的两半, 前一半为 a, 后一半为 b.
    两个字符串相似的前提是它们都含有相同数目的元音('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').
    注意, s 可能同时含有大写和小写字母.
    如果 a 和 b 相似, 返回 true; 否则, 返回 false.
 */
public class halvesAreAlike_1704 {
    public boolean halvesAreAlike(String s) {
        char[] cs = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        List<Character> list = new ArrayList<>();
        int n = s.length() / 2;
        int num = 0;
        for(char c : cs){
            list.add(c);
        }
        for(int i = 0; i < n; i++){
            if(list.contains(s.charAt(i))){
                num++;
            }
            if(list.contains(s.charAt(n + i))){
                num--;
            }
        }
        return num == 0;
    }
}
