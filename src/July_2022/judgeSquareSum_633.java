package July_2022;

/*
    给定一个非负整数 c, 你要判断是否存在两个整数 a 和 b, 使得 a2 + b2 = c .
 */

public class judgeSquareSum_633 {
    public boolean judgeSquareSum(int c) {
        if(c == 0)
            return true;
        long left = 0, right = (long)Math.sqrt(c);
        while(left <= right){
            long num = left * left + right * right;
            if(num < c){
                left++;
            }else if(num > c){
                right--;
            }else{
                return true;
            }
        }
        return false;
    }
}
