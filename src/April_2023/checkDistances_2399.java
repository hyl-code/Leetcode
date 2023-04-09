package April_2023;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    给你一个下标从 0 开始的字符串 s, 该字符串仅由小写英文字母组成, s 中的每个字母都恰好出现两次.
    另给你一个下标从 0 开始, 长度为 26 的的整数数组 distance.
    字母表中的每个字母按从 0 到 25 依次编号(即, 'a' -> 0, 'b' -> 1, 'c' -> 2, ... , 'z' -> 25).
    在一个匀整字符串中, 第 i 个字母的两次出现之间的字母数量是 distance[i].
    如果第 i 个字母没有在 s 中出现, 那么 distance[i] 可以忽略.
    如果 s 是一个匀整字符串, 返回 true; 否则, 返回 false.
 */
public class checkDistances_2399 {
    // 数组
    public boolean checkDistances(String s, int[] distance) {
        int[] index = new int[26];
        Arrays.fill(index, -1);
        for(int i = 0; i < s.length(); i++){
            int idx = s.charAt(i) - 'a';
            if(index[idx] != -1 && i - index[idx] - 1 != distance[idx]){
                return false;
            }
            index[idx] = i;
        }
        return true;
    }

    // HashMap
    public boolean checkDistances1(String s, int[] distance) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            int index = s.charAt(i) - 'a';
            map.put(index, i - map.getOrDefault(index, -1));
        }
        for(int i = 0; i < 26; i++){
            if(map.containsKey(i) && map.get(i) != distance[i]){
                return false;
            }
        }
        return true;
    }

    // 暴力枚举
    public boolean checkDistances2(String s, int[] distance) {
        for(int i = 0; i < s.length(); i++){
            for(int j = i + 1; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j) && distance[s.charAt(i) - 'a'] != j - i - 1){
                    return false;
                }
            }
        }
        return true;
    }
}
