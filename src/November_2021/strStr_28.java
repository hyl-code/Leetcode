package November_2021;

/*
    实现 strStr() 函数 .
    给你两个字符串 haystack 和 needle, 请你在 haystack 字符串中找出 needle 字符串出现的第一个位置(下标从 0 开始).
    如果不存在, 则返回  -1 .
 */

public class strStr_28 {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        for(int i = 0; i <= haystack.length() - needle.length(); i++){
            int flag = 1;
            for(int j = 0; j < needle.length(); j++){
                if(haystack.charAt(i + j) != needle.charAt(j)){
                    flag = 0;
                }
            }
            if(flag == 1){
                return i;
            }
        }
        return -1;
    }

    //KMP算法
    public int strStr2(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        int[] next = new int[needle.length()];
        for(int i = 1, j = 0; i < needle.length(); i++){
            while(j > 0 && needle.charAt(i) != needle.charAt(j)){
                j = next[j - 1];
            }
            if(needle.charAt(i) == needle.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        for(int i = 0, j = 0; i < haystack.length();i++){
            while(j > 0 && haystack.charAt(i) != needle.charAt(j)){
                j = next[j - 1];
            }
            if(haystack.charAt(i) == needle.charAt(j)){
                j++;
            }
            if(j == needle.length()){
                return i - needle.length() + 1;
            }
        }
        return -1;
    }
}
