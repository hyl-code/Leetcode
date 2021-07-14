package July_2021;

//实现int sqrt(int x)函数。
//
//计算并返回 x 的平方根，其中 x 是非负整数。
//
//由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

public class MySqrt {
    //二分法
    public int mySqrt(int x) {
        if(x == 1)
            return x;
        int min = 0;
        int max = x;
        while(max - min > 1){
            int i = (min + max) / 2;
            if(x / i < i)
                max = i;
            else
                min = i;
        }
        return min;
    }
}
