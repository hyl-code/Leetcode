package May_2023;

/*
    给定一个二进制字符串 s 和一个正整数 n, 如果对于 [1, n] 范围内的每个整数, 其二进制表示都是 s 的 子字符串, 就返回 true, 否则返回 false.
    子字符串是字符串中连续的字符序列.
 */

public class queryString_1016 {
    public boolean queryString(String s, int n) {
        for(int i = 1; i <= n; i++){
            if(!s.contains(Integer.toBinaryString(i))){
                return false;
            }
        }
        return true;
    }
}
