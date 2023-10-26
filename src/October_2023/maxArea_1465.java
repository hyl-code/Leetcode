package October_2023;

import java.util.Arrays;
/*
    矩形蛋糕的高度为 h 且宽度为 w, 给你两个整数数组 horizontalCuts 和 verticalCuts, 其中：
        horizontalCuts[i] 是从矩形蛋糕顶部到第 i 个水平切口的距离
        verticalCuts[j] 是从矩形蛋糕的左侧到第 j 个竖直切口的距离
    请你按数组 horizontalCuts 和 verticalCuts 中提供的水平和竖直位置切割后, 请你找出面积最大的那份蛋糕, 并返回其面积.
    由于答案可能是一个很大的数字, 因此需要将结果 对 10^9 + 7 取余 后返回.
 */
public class maxArea_1465 {
    // 贪心
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        return (int)((long)calMax(horizontalCuts, h) * calMax(verticalCuts, w) % 1000000007);
    }

    private int calMax(int[] arr, int boarder){
        int res = 0;
        int pre = 0;
        for(int i : arr){
            res = Math.max(i - pre, res);
            pre = i;
        }
        return Math.max(res, boarder - pre);
    }
}
