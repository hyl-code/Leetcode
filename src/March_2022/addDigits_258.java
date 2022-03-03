package March_2022;

/*
    给定一个非负整数 num, 反复将各个位上的数字相加, 直到结果为一位数.
    返回这个结果.
 */

public class addDigits_258 {
    public int addDigits(int num) {
        while(num >= 10){
            int res = 0;
            while(num > 0){
                res += num % 10;
                num /= 10;
            }
            num = res;
        }
        return num;
    }
}
