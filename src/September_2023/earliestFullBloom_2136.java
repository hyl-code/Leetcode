package September_2023;

import java.util.Arrays;
/*
    你有 n 枚花的种子. 每枚种子必须先种下, 才能开始生长、开花. 播种需要时间, 种子的生长也是如此.
    给你两个下标从 0 开始的整数数组 plantTime 和 growTime, 每个数组的长度都是 n ：
        plantTime[i] 是播种第 i 枚种子所需的完整天数. 每天, 你只能为播种某一枚种子而劳作.
        无须连续几天都在种同一枚种子, 但是种子播种必须在你工作的天数达到 plantTime[i] 之后才算完成.
        growTime[i] 是第 i 枚种子完全种下后生长所需的完整天数. 在它生长的最后一天之后, 将会开花并且永远绽放.

    从第 0 开始, 你可以按任意顺序播种种子.
    返回所有种子都开花的最早一天是第几天.
 */
public class earliestFullBloom_2136 {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        var id = new Integer[n];
        for(int i = 0; i < n; i++){
            id[i] = i;
        }
        Arrays.sort(id, (i, j) -> growTime[j] - growTime[i]);   // 按照生长天数从大到小排序
        int res = 0, days = 0;
        for(int i : id){
            days += plantTime[i];       // 累加播种天数
            res = Math.max(res, days + growTime[i]);        // 再加上生长天数, 就是这个种子的开花时间
        }
        return res;
    }
}
