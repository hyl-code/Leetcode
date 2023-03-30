package March_2023;

import java.util.Arrays;

/*
    给你 n 个二维平面上的点 points, 其中 points[i] = [xi, yi],
    请你返回两点之间内部不包含任何点的最宽垂直区域的宽度.
    垂直区域的定义是固定宽度, 而 y 轴上无限延伸的一块区域(也就是高度为无穷大).
    最宽垂直区域为宽度最大的一个垂直区域.
    请注意, 垂直区域边上的点不在区域内.
 */
public class maxWidthOfVerticalArea_1637 {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        int res = 0;
        for(int i = 1; i < points.length; i++){
            res = Math.max(points[i][0] - points[i - 1][0], res);
        }
        return res;
    }
}
