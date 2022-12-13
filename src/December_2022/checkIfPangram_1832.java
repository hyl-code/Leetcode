package December_2022;

import java.util.HashMap;
/*
    全字母句指包含英语字母表中每个字母至少一次的句子.
    给你一个仅由小写英文字母组成的字符串 sentence, 请你判断 sentence 是否为全字母句.
    如果是, 返回 true; 否则, 返回 false.
 */
public class checkIfPangram_1832 {
    public boolean checkIfPangram(String sentence) {
        if(sentence.length() < 26){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : sentence.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map.size() == 26;
    }
}
