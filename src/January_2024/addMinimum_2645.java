package January_2024;

/*
    给你一个字符串 word, 你可以向其中任何位置插入 "a"、"b" 或 "c" 任意次, 返回使 word 有效需要插入的最少字母数.
    如果字符串可以由 "abc" 串联多次得到, 则认为该字符串有效.
 */
public class addMinimum_2645 {
    public int addMinimum(String word) {
        int n = word.length();
        int[] d = new int[n + 1];
        for(int i = 1; i <= n; i++){
            d[i] = d[i - 1] + 2;
            if(i > 1 && word.charAt(i - 1) > word.charAt(i - 2)){
                d[i] = d[i - 1] - 1;
            }
        }
        return d[n];
    }
}
