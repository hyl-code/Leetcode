package December_2023;

/*
    给你一个用无限二维网格表示的花园, 每一个整数坐标处都有一棵苹果树.
    整数坐标 (i, j) 处的苹果树有 |i| + |j| 个苹果.
    你将会买下正中心坐标是 (0, 0) 的一块正方形土地, 且每条边都与两条坐标轴之一平行.
    给你一个整数 neededApples, 请你返回土地的最小周长, 使得至少有 neededApples 个苹果在土地里面或者边缘上.
    |x| 的值定义为：
        如果 x >= 0, 那么值为 x
        如果 x < 0, 那么值为 -x
 */
public class minimumPerimeter_1954 {
    public long minimumPerimeter(long neededApples) {
        long n = 1;
        while(2 * n * (n + 1) * (2 * n + 1) < neededApples){
            n++;
        }
        return n * 8;
    }
}
