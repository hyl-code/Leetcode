package October_2021;

/*
    给定一个字符串 s , 请你找出其中不含有重复字符的 最长子串 的长度 .
 */

import java.util.HashMap;

public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring1(String s) {
        String max = "", temp = "";
        if(s != null && s.length() > 0 && s != ""){
            char[] strChar = s.toCharArray();
            int i = 0, j;
            while(i < s.length()){
                StringBuilder sb = new StringBuilder();
                int flag = 0;
                for(j = i; j < s.length() && flag != 1; j++){
                    String str = Character.toString(strChar[j]);
                    if(!temp.contains(str)){
                        sb.append(str);
                    }else{
                        flag = 1;
                    }
                    temp = sb.toString();
                }
                i++;
                max = temp.length() > max.length() ? temp : max;
                temp = "";
            }
        }
        return max.length();
    }

    public int lengthOfLongestSubstring2(String s) {
        if(s.length() == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0, temp = 0;
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                temp = Math.max(temp, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - temp + 1);
        }
        return max;
    }
}
