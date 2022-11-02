package November_2022;

/*
    给你一个数组 towers 和一个整数 radius.
    数组 towers 中包含一些网络信号塔, 其中 towers[i] = [xi, yi, qi] 表示第 i 个网络信号塔的坐标是 (xi, yi)
    且信号强度参数为 qi.
    所有坐标都是在 X-Y 坐标系内的整数坐标. 两个坐标之间的距离用欧几里得距离计算.
    整数 radius 表示一个塔能到达的最远距离.
    如果一个坐标跟塔的距离在 radius 以内, 那么该塔的信号可以到达该坐标.
    在这个范围以外信号会很微弱, 所以 radius 以外的距离该塔是不能到达的.
    如果第 i 个塔能到达 (x, y), 那么该塔在此处的信号为 ⌊qi / (1 + d)⌋, 其中 d 是塔跟此坐标的距离.
    一个坐标的信号强度是所有能到达该坐标的塔的信号强度之和.
    请你返回数组 [cx, cy], 表示信号强度最大的整数坐标点(cx, cy).
    如果有多个坐标网络信号一样大, 请你返回字典序最小的非负坐标.
注意:
    坐标(x1, y1)字典序比另一个坐标(x2, y2)小, 需满足以下条件之一:
        要么 x1 < x2 ;
        要么 x1 == x2 且  y1 < y2.
        ⌊val⌋ 表示小于等于 val 的最大整数(向下取整函数).
 */
public class bestCoordinate_1620 {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int xMax = Integer.MIN_VALUE, yMax = Integer.MIN_VALUE;
        for(int[] tower : towers){
            int x = tower[0], y = tower[1];
            xMax = Math.max(x, xMax);
            yMax = Math.max(y, yMax);
        }
        int cx = 0, cy = 0;
        int maxQuality = 0;
        // x 和 y 从小到大遍历, 省去选择字典序最小的坐标这一环节.
        for(int x = 0; x <= xMax; x++){
            for(int y = 0; y <= yMax; y++){
                int[]  coordinate = {x, y};
                int quality = 0;
                for(int[] tower : towers){
                    int SquaredDis = getDistance(coordinate, tower);
                    if(SquaredDis <= radius * radius){
                        double dis = Math.sqrt(SquaredDis);
                        //Math.floor(): 对浮点数向下取整
                        quality += (int) Math.floor(tower[2] / (1 + dis));
                    }
                }
                if(quality > maxQuality){
                    cx = x;
                    cy = y;
                    maxQuality = quality;
                }
            }
        }
        return new int[]{cx, cy};
    }

    public int getDistance(int[] coordinate, int[] tower){
        return (tower[0] - coordinate[0]) * (tower[0] - coordinate[0]) + (tower[1] - coordinate[1]) * (tower[1] - coordinate[1]);
    }
}
