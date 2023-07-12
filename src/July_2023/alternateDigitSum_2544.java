package July_2023;

/*
    给你一个正整数 n.
    n 中的每一位数字都会按下述规则分配一个符号：
        最高有效位上的数字分配到正号.
        剩余每位上数字的符号都与其相邻数字相反.
    返回所有数字及其对应符号的和.
 */
public class alternateDigitSum_2544 {
    public int alternateDigitSum(int n) {
        int res = 0, pre = 1;
        while(n > 0){
            res += pre * (n % 10);
            pre = -pre;
            n /= 10;
        }
        return -pre * res;
    }
}
