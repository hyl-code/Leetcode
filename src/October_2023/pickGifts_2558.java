package October_2023;

import java.util.Arrays;
import java.util.PriorityQueue;
/*
    给你一个整数数组 gifts, 表示各堆礼物的数量. 每一秒, 你需要执行以下操作：
        选择礼物数量最多的那一堆.
        如果不止一堆都符合礼物数量最多, 从中选择任一堆即可.
        选中的那一堆留下平方根数量的礼物（向下取整）, 取走其他的礼物.
    返回在 k 秒后剩下的礼物数量.
 */
public class pickGifts_2558 {
    // 暴力
    public long pickGifts(int[] gifts, int k) {
        long sum = 0;
        int idx = gifts.length - 1;
        for(int i = 0; i < k; i++){
            Arrays.sort(gifts);
            gifts[idx] = (int) Math.sqrt(gifts[idx]);
        }
        for(int gift : gifts){
            sum += gift;
        }
        return sum;
    }

    // 最大堆
    public long pickGifts2(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        for(int gift : gifts){
            pq.offer(gift);
        }
        while(k > 0){
            k--;
            int x = pq.poll();
            pq.offer((int) Math.sqrt(x));
        }
        long sum = 0;
        while(!pq.isEmpty()){
            sum += pq.poll();
        }
        return sum;
    }
}
