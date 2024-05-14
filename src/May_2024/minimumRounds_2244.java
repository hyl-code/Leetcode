package May_2024;

import java.util.HashMap;
import java.util.Map;
/*
    给你一个下标从 0 开始的整数数组 tasks，其中 tasks[i] 表示任务的难度级别. 在每一轮中，你可以完成 2 个或者 3 个相同难度级别的任务.
    返回完成所有任务需要的最少轮数，如果无法完成所有任务，返回 -1.
 */
public class minimumRounds_2244 {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        int res = 0;
        for (int val : map.values()) {
            if (val < 2) {
                return -1;
            }
            int mod = val % 3 > 0 ? 1 : 0;
            res += (val / 3) + mod;
        }
        return res;
    }
}
