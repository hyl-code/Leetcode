package November_2021;

/*
    给你一个整数 n ,请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位数字。
    示例 1 :
        输入 : n = 3
        输出 : 3
 */

public class findNthDigit_400 {
    //直接计算
    public int findNthDigit1(int n) {
        int len = 1;    //数字长度
        while(len * 9 * Math.pow(10, len - 1) < n){
            n -= len * 9 * Math.pow(10,len - 1);
            len++;
        }
        long s = (long) Math.pow(10, len - 1);  //长度最小值
        long t = n / len - 1 + s;   //目标值
        n -= (t - s + 1) * len;
        return n == 0 ? (int)(t % 10) : (int)((t + 1) / Math.pow(10, len - n) % 10);
    }
}
