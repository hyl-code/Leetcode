package June_2022;

/*
    给你一个非负整数 x , 计算并返回 x 的算术平方根 .

    由于返回类型是整数, 结果只保留整数部分, 小数部分将被舍去 .

    注意：不允许使用任何内置指数函数和算符, 例如 pow(x, 0.5) 或者 x ** 0.5 .
 */

public class mySqrt_69 {
    public int mySqrt(int x) {
        if(x == 1)
            return 1;
        int left = 0, right = x;
        while(right - left > 1){
            int mid = left + (right - left) / 2;
            if(x / mid >= mid){
                left = mid;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
