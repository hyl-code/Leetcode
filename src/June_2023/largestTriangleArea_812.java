package June_2023;

/*
    给你一个由 X-Y 平面上的点组成的数组 points, 其中 points[i] = [xi, yi] .
    从其中取任意三个不同的点组成三角形, 返回能组成的最大三角形的面积.
    与真实值误差在 10^(-5) 内的答案将会视为正确答案.
 */
public class largestTriangleArea_812 {
    public double largestTriangleArea(int[][] points) {
        double res = 0;
        for(int i = 0; i < points.length; i++){
            for(int j = i + 1; j < points.length; j++){
                for(int k = j + 1; k < points.length; k++){
                    res = Math.max(res, getArea(points[i], points[j], points[k]));
                }
            }
        }
        return res;
    }

    public double getArea(int[] p1, int[] p2, int[] p3){
        double a = Math.sqrt(Math.pow(p2[1] - p1[1], 2) + Math.pow(p2[0] - p1[0], 2));
        double b = Math.sqrt(Math.pow(p3[1] - p1[1], 2) + Math.pow(p3[0] - p1[0], 2));
        double c = Math.sqrt(Math.pow(p3[1] - p2[1], 2) + Math.pow(p3[0] - p2[0], 2));
        double p = (a + b + c) / 2;
        return Math.sqrt(Math.abs(p * (p - a) * (p - b) * (p - c)));
    }
}
