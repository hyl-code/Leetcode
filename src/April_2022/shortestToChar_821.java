package April_2022;

/*
    给你一个字符串 s 和一个字符 c, 且 c 是 s 中出现过的字符 .
    返回一个整数数组 answer, 其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 .
    两个下标 i 和 j 之间的 距离 为 abs(i - j), 其中 abs 是绝对值函数 .
 */

public class shortestToChar_821 {
    //分别从左, 右两个方向 两次遍历
    public int[] shortestToChar(String s, char c) {
        int len = s.length();
        int[] res = new int[len];
        for(int i = 0, index = -len; i < len; i++){
            if(s.charAt(i) == c){
                index = i;
            }
            res[i] = i - index;
        }
        for(int i = len - 1, index = 2 * len; i >= 0; i--){
            if(s.charAt(i) == c){
                index = i;
            }
            res[i] = Math.min(res[i], index - i);
        }
        return res;
    }
}
