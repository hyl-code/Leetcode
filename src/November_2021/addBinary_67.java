package November_2021;

/*
    给你两个二进制字符串, 返回它们的和(用二进制表示) .
    输入为非空字符串且只包含数字 1 和 0 .
 */

public class addBinary_67 {
    public String addBinary(String a, String b) {
        if(a == null || a.length() == 0)
            return b;
        if(b == null || b.length() == 0)
            return a;
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int tag = 0;
        while(i >= 0 || j >= 0){
            if(i >= 0){
                tag += a.charAt(i--) - '0';
            }
            if(j >= 0){
                tag += b.charAt(j--) - '0';
            }
            sb.append(tag % 2);
            tag >>= 1;
        }
        String res = sb.reverse().toString();
        return tag > 0 ? '1' + res : res;
    }
}
