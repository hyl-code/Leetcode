package November_2022;

import java.util.ArrayList;
import java.util.List;

/*
    给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words.
    如果一个字符串的每一个字符都在 allowed 中, 就称这个字符串是一致字符串.
    请你返回 words 数组中一致字符串的数目.
 */
public class countConsistentStrings_1684 {
    //暴力
    public int countConsistentStrings(String allowed, String[] words) {
        int res = 0;
        List<Character> list = new ArrayList<>();
        for(int i = 0; i < allowed.length(); i++){
            list.add(allowed.charAt(i));
        }
        for(String s : words){
            int flag = 1;
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(!list.contains(c)){
                    flag = 0;
                    break;
                }
            }
            if(flag == 1){
                res++;
            }
        }
        return res;
    }
}
