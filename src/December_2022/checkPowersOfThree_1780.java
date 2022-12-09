package December_2022;

/*
    给你一个整数 n, 如果你可以将 n 表示成若干个不同的三的幂之和, 请你返回 true, 否则请返回 false.
    对于一个整数 y, 如果存在整数 x 满足 y == 3^x, 我们称这个整数 y 是三的幂.
 */
public class checkPowersOfThree_1780 {
    public boolean checkPowersOfThree(int n) {
        while(n != 0){
            if(n % 3 == 0 || n % 3 == 1){
                n /= 3;
            }else{
                return false;
            }
        }
        return true;
    }
}
