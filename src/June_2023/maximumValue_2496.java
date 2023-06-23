package June_2023;

/*
    一个由字母和数字组成的字符串的值定义如下：
        如果字符串只包含数字, 那么值为该字符串在 10 进制下的所表示的数字.
        否则, 值为字符串的长度.

    给你一个字符串数组 strs, 每个字符串都只由字母和数字组成, 请你返回 strs 中字符串的最大值.
 */
public class maximumValue_2496 {
    public int maximumValue(String[] strs) {
        int res = 0;
        for(int i = 0; i < strs.length; i++){
            res = Math.max(res, getValue(strs[i]));
        }
        return res;
    }

    public int getValue(String str){
        int val = 0;
        for(int i = 0; i < str.length(); i++){
            int c = str.charAt(i);
            if(!Character.isDigit(c)){
                return str.length();
            }
        }
        for(int i = 0; i < str.length(); i++){
            int c = str.charAt(i);
            if(c != 0){
                val *= 10;
                val += (c - '0');
            }
        }
        return val;
    }
}
