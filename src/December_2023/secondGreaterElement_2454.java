package December_2023;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;
/*
    给你一个下标从 0 开始的非负整数数组 nums. 对于 nums 中每一个整数, 你必须找到对应元素的第二大整数.
    如果 nums[j] 满足以下条件, 那么我们称它为 nums[i] 的第二大整数：
        j > i
        nums[j] > nums[i]
        恰好存在 一个 k 满足 i < k < j 且 nums[k] > nums[i].
    如果不存在 nums[j], 那么第二大整数为 -1.

        比方说, 数组 [1, 2, 4, 3] 中, 1 的第二大整数是 4, 2 的第二大整数是 3, 3 和 4 的第二大整数是 -1.
    请你返回一个整数数组 answer, 其中 answer[i]是 nums[i] 的第二大整数.
 */
public class secondGreaterElement_2454 {
    public int[] secondGreaterElement(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<Integer>();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        for(int i = 0; i < nums.length; i++){
            while(!pq.isEmpty() && pq.peek()[0] < nums[i]){
                res[pq.poll()[1]] = nums[i];
            }
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                pq.offer(new int[]{nums[stack.peek()], stack.peek()});
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
