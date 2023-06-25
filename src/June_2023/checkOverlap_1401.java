package June_2023;

/*
    给你一个以 (radius, xCenter, yCenter) 表示的圆和一个与坐标轴平行的矩形 (x1, y1, x2, y2),
        其中 (x1, y1) 是矩形左下角的坐标，而 (x2, y2) 是右上角的坐标.
    如果圆和矩形有重叠的部分, 请你返回 true, 否则返回 false.
    换句话说, 请你检测是否存在点 (xi, yi), 它既在圆上也在矩形上（两者都包括点落在边界上的情况）.
 */
public class checkOverlap_1401 {
    //求圆的原点到矩形的最短距离：若最短距离 <= radius, 说明存在公共点.
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        double dist = 0;
        if(xCenter < x1 || xCenter > x2){
            dist += Math.min(Math.pow(x1 - xCenter, 2), Math.pow(xCenter - x2, 2));
        }
        if(yCenter < y1 || yCenter > y2){
            dist += Math.min(Math.pow(y1 - yCenter, 2), Math.pow(yCenter - y2, 2));
        }
        return dist <= radius * radius;
    }
}
