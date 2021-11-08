package May_2021;

    //有台奇怪的打印机有以下两个特殊要求：

    //打印机每次只能打印由 同一个字符 组成的序列。
    //每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。
    //给你一个字符串 s ，你的任务是计算这个打印机打印它需要的最少打印次数。

public class StrangePrinter_664 {
    public int strangePrinter(String s) {
        int len = s.length();
        int[][] num = new int[len][len];

        for(int i = len - 1; i >= 0; i--){
            num[i][i] = 1;
            for(int j = i + 1; j < len; j++){
                if(s.charAt(i) == s.charAt(j)){
                    num[i][j] = num[i][j - 1];
                }else{
                    int min_num = Integer.MAX_VALUE;
                    for(int k = i; k < j; k++){
                        min_num = Math.min(min_num, num[i][k] + num[k + 1][j]);
                    }
                    num[i][j] = min_num;
                }
            }
        }
        return num[0][len - 1];
    }
}   // 动态规划
