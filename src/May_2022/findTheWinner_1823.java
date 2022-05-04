package May_2022;

import java.util.LinkedList;
import java.util.Queue;

public class findTheWinner_1823 {
    //栈模拟
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            queue.add(i);
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j < k; j++){
                queue.add(queue.poll());
            }
            queue.poll();
        }
        return queue.poll();
    }

    //数学 + 递归
    //f(n, k) = (k′ mod n + x − 1 ) mod n + 1 = ( k + x − 1 ) mod n + 1 .
    //k': 第 k' 名小伙伴离开圈子
    public int findTheWinner1(int n, int k) {
        if(n == 1)
            return 1;
        return (k + findTheWinner1(n - 1, k) - 1) % n + 1;
    }

    //数学 + 迭代
    public int findTheWinner2(int n, int k) {
        int res = 1;
        for(int i = 2; i <= n; i++){
            res = (k + res - 1) % i + 1;
        }
        return res;
    }
}
