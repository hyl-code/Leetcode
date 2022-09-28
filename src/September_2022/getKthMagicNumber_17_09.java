package September_2022;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*
    有些数的素因子只有 3, 5, 7, 请设计一个算法找出第 k 个数 .
    注意, 不是必须有这些素因子, 而是必须不包含其他的素因子 .
    例如, 前几个数按顺序应该是 1, 3, 5, 7, 9, 15, 21 .
 */
public class getKthMagicNumber_17_09 {
    public int getKthMagicNumber(int k) {
        //优先队列 (小根堆)
        int[] nums = new int[]{3, 5, 7};
        PriorityQueue<Long> queue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        //起始先将最小数值 1 放入队列
        queue.add(1L);
        set.add(1L);
        while(!queue.isEmpty()){
            //每次从队列取出最小值 x，然后将 x 所对应的数值 3x、5x 和 7x 进行入队
            long n = queue.poll();
            //第 k 次出队的值即是答案
            if(--k == 0){
                return (int)n;
            }
            for(int num : nums){
                if(!set.contains(n * num)){
                    set.add(n * num);
                    queue.add(n * num);
                }
            }
        }
        return -1;
    }
}
