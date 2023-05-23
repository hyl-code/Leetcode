package May_2023;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    我们有一个 n 项的集合. 给出两个整数数组 values 和 labels, 第 i 个元素的值和标签分别是 values[i] 和 labels[i].
    还会给出两个整数 numWanted 和 useLimit.
    从 n 个元素中选择一个子集 s :
        子集 s 的大小小于或等于 numWanted.
        s 中最多有相同标签的 useLimit 项.
        一个子集的分数是该子集的值之和.
    返回子集 s 的最大分数.
 */
public class largestValsFromLabels_1090 {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        //用二维数组存{ value, label }, 保证一一对应
        int[][] pairs = new int[values.length][2];
        int res = 0, num = 0;
        for(int i = 0; i < values.length; i++){
            pairs[i] = new int[]{values[i], labels[i]};
        }
        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);
        //用 map 计 label 出现次数, num 记子集目前的大小(需要 <= numWanted)
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < values.length && num < numWanted; i++){
            int value = pairs[i][0], label = pairs[i][1];
            if(map.getOrDefault(label, 0) < useLimit){
                map.put(label, map.getOrDefault(label, 0) + 1);
                num++;
                res += value;
            }
        }
        return res;
    }
}
