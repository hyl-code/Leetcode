package November_2021;

/*
    给定一个 正整数 num ,编写一个函数, 如果 num 是一个完全平方数, 则返回 true , 否则返回 false .
    进阶: 不要使用任何内置的库函数, 如 sqrt .
 */

public class isPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int left = 1, right = num;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int t = num / mid;
            if(t == mid){
                if(num % mid == 0)
                    return true;
                left = mid + 1;
            }else if(t < mid){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }
}
