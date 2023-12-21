package December_2023;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
/*
    给你一个长度为 n 下标从 0 开始的整数数组 maxHeights.
    你的任务是在坐标轴上建 n 座塔. 第 i 座塔的下标为 i, 高度为 heights[i].
    如果以下条件满足, 我们称这些塔是美丽的：
        1 <= heights[i] <= maxHeights[i]
        heights 是一个山脉数组.
    如果存在下标 i 满足以下条件, 那么我们称数组 heights 是一个山脉数组：
        对于所有 0 < j <= i, 都有 heights[j - 1] <= heights[j]
        对于所有 i <= k < n - 1, 都有 heights[k + 1] <= heights[k]
    请你返回满足美丽塔要求的方案中, 高度和的最大值.
 */
public class maximumSumOfHeights_2866 {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long res = 0;
        long[] prefix = new long[n];
        long[] suffix = new long[n];
        Deque<Integer> stack1 = new ArrayDeque<Integer>();
        Deque<Integer> stack2 = new ArrayDeque<Integer>();
        for(int i = 0; i < n; i++){
            while(!stack1.isEmpty() && maxHeights.get(i) < maxHeights.get(stack1.peek())){
                stack1.pop();
            }
            if(stack1.isEmpty()){
                prefix[i] = (long) (i + 1) * maxHeights.get(i);
            }else{
                prefix[i] = prefix[stack1.peek()] + (long) (i - stack1.peek()) * maxHeights.get(i);
            }
            stack1.push(i);
        }
        for(int i = n - 1; i >= 0; i--){
            while(!stack2.isEmpty() && maxHeights.get(i) < maxHeights.get(stack2.peek())){
                stack2.pop();
            }
            if(stack2.isEmpty()){
                suffix[i] = (long) (n - i) * maxHeights.get(i);
            }else{
                suffix[i] = suffix[stack2.peek()] + (long) (stack2.peek() - i) * maxHeights.get(i);
            }
            stack2.push(i);
            res = Math.max(res, prefix[i] + suffix[i] - maxHeights.get(i));
        }
        return res;
    }
}
