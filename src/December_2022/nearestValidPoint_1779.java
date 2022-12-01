package December_2022;

/*
    给你两个整数 x 和 y, 表示你在一个笛卡尔坐标系下的 (x, y) 处.
    同时, 在同一个坐标系下给你一个数组 points, 其中 points[i] = [ai, bi] 表示在 (ai, bi) 处有一个点.
    当一个点与你所在的位置有相同的 x 坐标或者相同的 y 坐标时, 我们称这个点是有效的.
    请返回距离你当前位置曼哈顿距离最近的有效点的下标(下标从 0 开始).
    如果有多个最近的有效点, 请返回下标最小的一个.
    如果没有有效点, 请返回 -1.
    两个点 (x1, y1) 和 (x2, y2) 之间的曼哈顿距离为 abs(x1 - x2) + abs(y1 - y2).
 */
public class nearestValidPoint_1779 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        if(points.length == 1){
            return (points[0][0] == x && points[0][1] == y) ? 0 : -1;
        }
        int min = Integer.MAX_VALUE;
        int res = -1;
        for(int i = 0; i < points.length; i++){
            int a = points[i][0], b = points[i][1];
            if(a == x || b == y){
                int dis = Math.abs(a - x) + Math.abs(b - y);
                if(dis < min){
                    min = dis;
                    res = i;
                }
            }
        }
        return res;
    }
}
