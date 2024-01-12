package January_2024;

import java.util.HashMap;
import java.util.Map;
/*
    给你两个字符串数组 words1 和 words2, 请你返回在两个字符串数组中都恰好出现一次的字符串的数目.
 */
public class countWords_2085 {
    public int countWords(String[] words1, String[] words2) {
        int res = 0;
        Map<String, Integer> cnt1 = new HashMap<>();
        Map<String, Integer> cnt2 = new HashMap<>();
        for(String str : words1){
            cnt1.put(str, cnt1.getOrDefault(str, 0) + 1);
        }
        for(String str : words2){
            cnt2.put(str, cnt2.getOrDefault(str, 0) + 1);
        }
        for(String str : cnt1.keySet()){
            if(cnt1.get(str) == 1 && cnt2.getOrDefault(str, 0) == 1){
                res++;
            }
        }
        return res;
    }
}
