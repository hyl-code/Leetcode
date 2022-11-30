package November_2022;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
    设计一个类似堆栈的数据结构, 将元素推入堆栈, 并从堆栈中弹出出现频率最高的元素.
    实现 FreqStack 类:
        FreqStack() 构造一个空的堆栈.
        void push(int val) 将一个整数 val 压入栈顶.
        int pop() 删除并返回堆栈中出现频率最高的元素.
        如果出现频率最高的元素不只一个, 则移除并返回最接近栈顶的元素.
 */
public class FreqStack_895 {
    private int index;
    private Map<Integer, Integer> map;
    private PriorityQueue<int[]> queue;

    public FreqStack_895() {
        queue = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[1] == o2[1]){
                    return o2[2] - o1[2];
                }
                return o2[1] - o1[1];
            }
        });
        map = new HashMap<>();
        index = Integer.MIN_VALUE;
    }

    public void push(int val) {
        int cnt = map.getOrDefault(val, 0) + 1;
        map.put(val, cnt);
        queue.add(new int[]{val, cnt, index++});
    }

    public int pop() {
        int[] poll = queue.poll();
        map.put(poll[0], poll[1] - 1);
        return poll[0];
    }
}
