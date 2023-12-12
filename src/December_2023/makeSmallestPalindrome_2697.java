package December_2023;

/*
    给你一个由小写英文字母组成的字符串 s, 你可以对其执行一些操作. 在一步操作中, 你可以用其他小写英文字母替换 s 中的一个字符.
    请你执行尽可能少的操作, 使 s 变成一个回文串. 如果执行最少操作次数的方案不止一种, 则只需选取字典序最小的方案.
    对于两个长度相同的字符串 a 和 b, 在 a 和 b 出现不同的第一个位置,
        如果该位置上 a 中对应字母比 b 中对应字母在字母表中出现顺序更早, 则认为 a 的字典序比 b 的字典序要小.
    返回最终的回文字符串.
 */
public class makeSmallestPalindrome_2697 {
    public String makeSmallestPalindrome(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        for(int i = 0; i < n / 2; i++){
            if(cs[i] != cs[n - i - 1]){
                cs[i] = cs[n - i - 1] = (char)Math.min(cs[i], cs[n - i - 1]);
            }
        }
        return new String(cs);
    }
}
