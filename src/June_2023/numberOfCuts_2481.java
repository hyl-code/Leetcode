package June_2023;

/*
    圆内一个有效切割, 符合以下二者之一：
        该切割是两个端点在圆上的线段, 且该线段经过圆心.
        该切割是一端在圆心另一端在圆上的线段.
    给你一个整数 n, 请你返回将圆切割成相等的 n 等分的最少切割次数.
 */
public class numberOfCuts_2481 {
    public int numberOfCuts(int n) {
        if(n == 1){
            return 0;
        }
        return n % 2 == 0 ? n / 2 : n;
    }
}
