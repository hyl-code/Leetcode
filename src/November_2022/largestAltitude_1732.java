package November_2022;

/*
    有一个自行车手打算进行一场公路骑行, 这条路线总共由 n + 1 个不同海拔的点组成.
    自行车手从海拔为 0 的点 0 开始骑行.
    给你一个长度为 n 的整数数组 gain, 其中 gain[i] 是点 i 和点 i + 1 的净海拔高度差(0 <= i < n).
    请你返回最高点的海拔.
 */
public class largestAltitude_1732 {
    //前缀和
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int res = 0;
        int[] height = new int[n + 1];
        height[0] = 0;
        for(int i = 1; i <= n; i++){
            height[i] = height[i - 1] + gain[i - 1];
            res = Math.max(res, height[i]);
        }
        return res;
    }
}