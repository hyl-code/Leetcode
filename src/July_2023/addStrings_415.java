package July_2023;

/*
    给定两个字符串形式的非负整数 num1 和num2, 计算它们的和并同样以字符串形式返回.
    你不能使用任何內建的用于处理大整数的库（比如 BigInteger）, 也不能直接将输入的字符串转换为整数形式.
 */
public class addStrings_415 {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        while(i >= 0 || j >= 0 || carry != 0){
            if(i >= 0){
                carry += num1.charAt(i--) - '0';
            }
            if(j >= 0){
                carry += num2.charAt(j--) - '0';
            }
            sb.append(carry % 10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }
}
