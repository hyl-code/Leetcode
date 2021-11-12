package November_2021;

/*
    将一个给定字符串 s 根据给定的行数 numRows , 以从上往下, 从左到右进行 Z 字形排列 .
    比如输入字符串为 "PAYPALISHIRING" 行数为 3 时, 排列如下:
    P   A   H   N
    A P L S I I G
    Y   I   R
    之后, 你的输出需要从左往右逐行读取, 产生出一个新的字符串, 比如: "PAHNAPLSIIGYIR".
 */

public class convert_6 {
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int gap = numRows * 2 - 2;
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < len - i;j += gap){
                sb.append(s.charAt(i + j));
                if(i != 0 && i != numRows - 1 && j + gap - i < len){
                    sb.append(s.charAt(j + gap - i));
                }
            }
        }
        return sb.toString();
    }
}
