package March_2022;

/*
    给定两个字符串 s 和 t, 编写一个函数来判断 t 是否是 s 的字母异位词 .
    注意: 若 s 和 t 中每个字符出现的次数都相同, 则称 s 和 t 互为字母异位词 .
 */

public class isAnagram_242 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] arr = new int[26];;
        for(char c : s.toCharArray()){
            arr[c - 'a']++;
        }
        for(char c : t.toCharArray()){
            if(arr[c - 'a'] > 0){
                arr[c - 'a']--;
            }else{
                return false;
            }
        }
        return true;
    }
}
