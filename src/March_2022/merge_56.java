package March_2022;
import java.util.Arrays;
/*
    以数组 intervals 表示若干个区间的集合, 其中单个区间为 intervals[i] = [starti, endi] .
    请你合并所有重叠的区间, 并返回一个不重叠的区间数组, 该数组需恰好覆盖输入中的所有区间 .
 */

public class merge_56 {
    public int[][] merge(int[][] intervals) {
        //按照区间的起始位置排序
        Arrays.sort(intervals,(v1, v2) -> v1[0] - v2[0]);
        int[][] res = new int[intervals.length][2];
        int index = -1;
        //遍历区间
        for(int[] interval : intervals){
            //如果结果数组为空或当前区间对起始位置大于数组最后区间的终止位置, 则不合并, 直接加入结果数组
            //反之, 合并数组
            if(index == -1 || interval[0] > res[index][1]){
                res[++index] = interval;
            }else{
                res[index][1] = Math.max(res[index][1], interval[1]);
            }
        }
        //Arrays.copyOf()使得返回数组不含多余数组[0, 0]
        return Arrays.copyOf(res, index + 1);
    }
}
