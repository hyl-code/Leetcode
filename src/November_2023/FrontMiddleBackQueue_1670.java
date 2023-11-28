package November_2023;

import java.util.ArrayList;
import java.util.List;
/*
    请你设计一个队列, 支持在前、中、后三个位置的 push 和 pop 操作.
    请你完成 FrontMiddleBack 类：
        FrontMiddleBack() 初始化队列.
        void pushFront(int val) 将 val 添加到队列的最前面.
        void pushMiddle(int val) 将 val 添加到队列的正中间.
        void pushBack(int val) 将 val 添加到队里的最后面.
        int popFront() 将最前面的元素从队列中删除并返回值, 如果删除之前队列为空, 那么返回 -1.
        int popMiddle() 将正中间的元素从队列中删除并返回值, 如果删除之前队列为空, 那么返回 -1.
        int popBack() 将最后面的元素从队列中删除并返回值, 如果删除之前队列为空, 那么返回 -1.
    请注意当有两个中间位置的时候, 选择靠前面的位置进行操作. 比方说：
        将 6 添加到 [1, 2, 3, 4, 5] 的中间位置, 结果数组为 [1, 2, 6, 3, 4, 5].
        从 [1, 2, 3, 4, 5, 6] 的中间位置弹出元素, 返回 3 ，数组变为 [1, 2, 4, 5, 6].
 */
public class FrontMiddleBackQueue_1670 {
    List<Integer> list = new ArrayList<>();

    public FrontMiddleBackQueue_1670() {

    }

    public void pushFront(int val) {
        list.add(0, val);
    }

    public void pushMiddle(int val) {
        list.add(list.size() / 2, val);
    }

    public void pushBack(int val) {
        list.add(val);
    }

    public int popFront() {
        return list.isEmpty() ? -1 : list.remove(0);
    }

    public int popMiddle() {
        return list.isEmpty() ? -1 : list.remove((list.size() - 1) / 2);
    }

    public int popBack() {
        return list.isEmpty() ? -1 : list.remove(list.size() - 1);
    }
}
