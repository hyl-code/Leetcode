package November_2023;

import java.util.HashSet;
import java.util.Set;

/*
    给你一个下标从 0 开始的字符串数组 words 和两个整数：left 和 right.
    如果字符串以元音字母开头并以元音字母结尾, 那么该字符串就是一个元音字符串, 其中元音字母是 'a'、'e'、'i'、'o'、'u' .
    返回 words[i] 是元音字符串的数目, 其中 i 在闭区间 [left, right] 内.
 */
public class vowelStrings_2586 {
    public int vowelStrings(String[] words, int left, int right) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int res = 0;
        for(int i = left; i <= right; i++){
            if(set.contains(words[i].charAt(0)) && set.contains(words[i].charAt(words[i].length() - 1))){
                res++;
            }
        }
        return res;
    }
}
