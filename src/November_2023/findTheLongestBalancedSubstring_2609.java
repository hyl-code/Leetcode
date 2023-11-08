package November_2023;

/*
    给你一个仅由 0 和 1 组成的二进制字符串 s.
    如果子字符串中所有的 0 都在 1 之前且其中 0 的数量等于 1 的数量, 则认为 s 的这个子字符串是平衡子字符串.
    请注意, 空子字符串也视作平衡子字符串.
    返回 s 中最长的平衡子字符串长度.
    子字符串是字符串中的一个连续字符序列.
 */
public class findTheLongestBalancedSubstring_2609 {
    public int findTheLongestBalancedSubstring(String s) {
        int res = 0;
        int n = s.length();
        int[] cnt = new int[2];
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '1'){
                cnt[1]++;
                res = Math.max(res, 2 * Math.min(cnt[0], cnt[1]));
            }else if(i == 0 || s.charAt(i - 1) == '1'){
                cnt[0] = 1;
                cnt[1] = 0;
            }else{
                cnt[0]++;
            }
        }
        return res;
    }
}
