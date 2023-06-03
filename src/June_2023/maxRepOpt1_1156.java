package June_2023;

import java.util.HashMap;
import java.util.Map;

/*
    如果字符串中的所有字符都相同, 那么这个字符串是单字符重复的字符串.
    给你一个字符串 text, 你只能交换其中两个字符一次或者什么都不做, 然后得到一些单字符重复的子串.
    返回其中最长的子串的长度.
 */
public class maxRepOpt1_1156 {
    public int maxRepOpt1(String text) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < text.length(); i++){
            map.put(text.charAt(i), map.getOrDefault(text.charAt(i), 0) + 1);
        }
        int res = 0;
        for(int i = 0; i < text.length(); ){
            int j = i;
            //找出当前连续的一段 [i, j)
            while(j < text.length() && text.charAt(j) == text.charAt(i)){
                j++;
            }
            int cnt = j - i;
            //若这一段长度小于该字符出现总数, 并且前面或后面有空位, 则用 cnt + 1 更新答案
            if(cnt < map.getOrDefault(text.charAt(i), 0) && (j < text.length() || i > 0)){
                res = Math.max(res, cnt + 1);
            }
            //若相隔一个字符后为另一段[j + 1, k]), 则合并
            //否则 k = j + 1
            int k = j + 1;
            while(k < text.length() && text.charAt(k) == text.charAt(i)){
                k++;
            }
            res = Math.max(res, Math.min(k - i, map.getOrDefault(text.charAt(i), 0)));
            i = j;
        }
        return res;
    }
}
