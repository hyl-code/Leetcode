package October_2023;

/*
    给你一个整数 num, 返回 num 中能整除 num 的数位的数目.
    如果满足 nums % val == 0, 则认为整数 val 可以整除 nums.
 */
public class countDigits_2520 {
    public int countDigits(int num) {
        int res = 0;
        int tmp = num;
        while(tmp > 0){
            if(num % (tmp % 10) == 0){
                res++;
            }
            tmp /= 10;
        }
        return res;
    }
}
