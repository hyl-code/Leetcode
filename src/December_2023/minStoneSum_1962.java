package December_2023;

import java.util.PriorityQueue;
/*
    给你一个整数数组 piles, 数组下标从 0 开始, 其中 piles[i] 表示第 i 堆石子中的石子数量.
    另给你一个整数 k, 请你执行下述操作恰好 k 次：
        选出任一石子堆 piles[i], 并从中移除 floor(piles[i] / 2) 颗石子.
    注意：你可以对同一堆石子多次执行此操作.
    返回执行 k 次操作后, 剩下石子的最小总数.
    floor(x) 为小于或等于 x 的最大整数.（即, 对 x 向下取整）.
 */
public class minStoneSum_1962 {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> (b - a));
        for(int pile : piles){
            pq.offer(pile);
        }
        for(int i = 0; i < k; i++){
            int pile = pq.poll();
            pile -= pile / 2;
            pq.offer(pile);
        }
        int sum = 0;
        while(!pq.isEmpty()){
            sum += pq.poll();
        }
        return sum;
    }
}
