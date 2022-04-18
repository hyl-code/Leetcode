package April_2022;

import java.util.ArrayList;
import java.util.List;

/*
    给你一个整数 n ,按字典序返回范围 [1, n] 内所有整数 .
    你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法 .
 */

public class lexicalOrder_386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i < 10; i++){
            dfs(n, i, list);
        }
        return list;
    }

    public void dfs(int n, int num ,List<Integer> list) {
        if (num > n)
            return;
        list.add(num);
        num *= 10;
        for (int i = 0; i < 10; i++) {
            dfs(n, num + i, list);
        }
    }
}
