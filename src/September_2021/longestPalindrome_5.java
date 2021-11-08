package September_2021;

/*
    给你一个字符串 s, 找到 s 中最长的回文子串 .
*/

public class longestPalindrome_5 {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0)
            return "";

        int range[] = new int[2];
        char[] str = s.toCharArray();

        for(int i = 0; i < s.length(); i++){
            i = searchLongest(str, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    public int searchLongest(char[] str, int low, int[] range){
        int high = low;

        while(high < str.length - 1 && str[high+1] == str[low]){
            high++;
        }

        int res = high;

        while(low > 0 && high < str.length - 1 && str[low-1] == str[high+1]){
            low--;
            high++;
        }
        if(high - low > range[1] - range[0]){
            range[0] = low;
            range[1] = high;
        }
        return res;
    }
}
