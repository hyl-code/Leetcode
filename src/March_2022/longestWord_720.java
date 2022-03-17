package March_2022;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
    给出一个字符串数组 words 组成的一本英语词典 .
    返回 words 中最长的一个单词, 该单词是由 words 词典中其他单词逐步添加一个字母组成 .
    若其中有多个可行的答案, 则返回答案中字典序最小的单词 . 若无答案, 则返回空字符串 .
 */

public class longestWord_720 {
    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) ->{
            if(a.length() != b.length()){
                return a.length() - b.length();
            }else{
                return b.compareTo(a);
            }
        });
        String res = "";
        Set<String> set = new HashSet<String>();
        set.add("");
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            if(set.contains(word.substring(0, word.length() - 1))){
                set.add(word);
                res = word;
            }
        }
        return res;
    }
}
