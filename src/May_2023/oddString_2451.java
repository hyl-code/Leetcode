package May_2023;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    给你一个字符串数组 words, 每一个字符串长度都相同, 令所有字符串的长度都为 n.
    每个字符串 words[i] 可以被转化为一个长度为 n - 1 的差值整数数组 difference[i],
    其中对于 0 <= j <= n - 2 有 difference[i][j] = words[i][j+1] - words[i][j].
    注意两个字母的差值定义为它们在字母表中位置之差, 也就是说 'a' 的位置是 0, 'b' 的位置是 1, 'z' 的位置是 25.
    比方说, 字符串 "acb" 的差值整数数组是 [2 - 0, 1 - 2] = [2, -1].
    words 中所有字符串除了一个字符串以外, 其他字符串的差值整数数组都相同. 你需要找到那个不同的字符串.
    请你返回 words 中差值整数数组不同的字符串.
 */
public class oddString_2451 {
    public String oddString(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            String pattern = getPattern(word);
            map.put(pattern, map.getOrDefault(pattern, 0) + 1);
        }
        for(String word : words){
            String pattern = getPattern(word);
            if(map.get(pattern) == 1){
                return word;
            }
        }
        return null;
    }

    private String getPattern(String word){
        int n = word.length();
        int[] diff = new int[n];
        for(int i = 0; i < n - 1; i++){
            diff[i] = word.charAt(i + 1) - word.charAt(i);
        }
        return Arrays.toString(diff);
    }
}
