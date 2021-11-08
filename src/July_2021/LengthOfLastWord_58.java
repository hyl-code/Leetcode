package July_2021;

//给你一个字符串 s, 由若干单词组成, 单词之间用空格隔开. 返回字符串中最后一个单词的长度. 如果不存在最后一个单词,请返回 0.
//
//单词 是指仅由字母组成 不包含任何空格字符的最大子字符串。


public class LengthOfLastWord_58 {
    //执行用时: 2ms
    public int lengthOfLastWord(String s) {
        int len = 0;

        // 去掉字符串两端多余的空格
        s = s.trim();
        for(int i = 0; i < s.length(); i++ ){
            if(s.charAt(i) != ' '){
                len++;
            }else{
                len = 0;
            }
        }
        return len;
    }


    // 从后往前 执行用时: 0ms
    public int lengthOfLastWord2(String s) {
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } else if (length != 0) {
                return length;
            }
        }
        return length;
    }
}
