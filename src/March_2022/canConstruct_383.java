package March_2022;

/*
    给你两个字符串: ransomNote 和 magazine , 判断 ransomNote 能不能由 magazine 里面的字符构成 .
    如果可以, 返回 true ;否则返回 false .
    magazine 中的每个字符只能在 ransomNote 中使用一次 .
 */

public class canConstruct_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for(char c1 : magazine.toCharArray()){
            arr[c1 - 'a']++;
        }
        for(char c2 : ransomNote.toCharArray()){
            if(arr[c2 - 'a'] <= 0){
                return false;
            }
            arr[c2 - 'a']--;
        }
        return true;
    }
}
