package October_2022;

import java.util.Deque;
import java.util.LinkedList;

/*
    给你一个整数数组 nums 和一个整数 k, 找出 nums 中和至少为 k 的最短非空子数组, 并返回该子数组的长度.
    如果不存在这样的子数组, 返回 -1.
    子数组是数组中连续的一部分.
 */
public class shortestSubarray_862 {
    public int shortestSubarray(int[] nums, int k) {
        int min = nums.length + 1;
        long[] preSum = new long[nums.length + 1];
        preSum[0] = 0;
        for(int i = 1; i <= nums.length; i++){
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        //双端队列
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i <= nums.length; i++){
            //preSum[x2] <= preSum[x1]说明 x1-x2之间的元素之和为负数或 0
            //若 preSum[xn] - preSum[x1] >= k 则 preSum[xn] - preSum[x2] >= k
            while(!deque.isEmpty() && preSum[i] <= preSum[deque.getLast()]){
                //处理: 将队列末尾的 x1 扔掉
                deque.pollLast();
            }
            //当 preSum[x2] - preSum[x1] >= k时, 跳过 x1
            while(!deque.isEmpty() && preSum[i] - preSum[deque.getFirst()] >= k){
                //处理: 将 x1 的指针向后移动 1 位, 判断是否更新 min
                int len = i - deque.pollFirst();
                if(len < min){
                    min = len;
                }
            }
            //将 i 加入队列末尾
            deque.offerLast(i);
        }
        return min == nums.length + 1 ? -1 : min;
    }
}
