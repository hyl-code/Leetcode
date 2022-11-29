package November_2022;

/*
    给你一个仅由字符 '0' 和 '1' 组成的字符串 s.
    一步操作中, 你可以将任一 '0' 变成 '1', 或者将 '1' 变成 '0'.
    交替字符串定义为: 如果字符串中不存在相邻两个字符相等的情况, 那么该字符串就是交替字符串.
    例如, 字符串 "010" 是交替字符串, 而字符串 "0100" 不是.
    返回使 s 变成交替字符串所需的最少操作数.
 */
public class minOperations_1758 {
    //两种情况: 以 0 开头、 以 1 开头
    //两种不同的交替二进制字符串所需要的最少操作数加起来等于 s 的长度.
    public int minOperations(String s) {
        int num = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c != (char)('0' + i % 2)){
                num++;
            }
        }
        return Math.min(num, s.length() - num);
    }
}
