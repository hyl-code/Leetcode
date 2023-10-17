package October_2023;

import java.util.PriorityQueue;
/*
    给你一个下标从 0 开始的整数数组 nums 和一个整数 k. 你的起始分数为 0.
    在一步操作中：
        选出一个满足 0 <= i < nums.length 的下标 i；
        将你的分数增加 nums[i]；
        将 nums[i] 替换为 ceil(nums[i] / 3)。
    返回在恰好执行 k 次操作后, 你可能获得的最大分数.
    向上取整函数 ceil(val) 的结果是大于或等于 val 的最小整数.
 */
public class maxKelements_2530 {
    // 贪心 + 优先队列
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>((a, b) -> b - a);
        for(int num : nums){
            q.offer(num);
        }
        long res = 0;
        for(int i = 0; i < k; i++){
            int x = q.poll();
            res += x;
            q.offer((x + 2) / 3);
        }
        return res;
    }
}
