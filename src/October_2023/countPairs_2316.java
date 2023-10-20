package October_2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
    给你一个整数 n, 表示一张无向图中有 n 个节点, 编号为 0 到 n - 1.
    同时给你一个二维整数数组 edges, 其中 edges[i] = [ai, bi] 表示节点 ai 和 bi 之间有一条无向边.
    请你返回无法互相到达的不同点对数目.
 */
public class countPairs_2316 {
    public long countPairs(int n, int[][] edges) {
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        // 建图
        for(int[] e : edges){
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x);
        }
        boolean[] vis = new boolean[n];
        long res = 0;
        for(int i = 0, total = 0; i < n; i++){
            // 未访问的点：说明找到了一个新的连通块
            if(!vis[i]){
                int size = dfs(i, g, vis);
                res += (long) size * total;
                total += size;
            }
        }
        return res;
    }

    // 求当前连通块大小
    private int dfs(int x, List<Integer>[] g, boolean[] vis){
        vis[x] = true;  // 避免重复访问同一个点
        int size = 1;
        for(int y : g[x]){
            if(!vis[y]){
                size += dfs(y, g, vis);
            }
        }
        return size;
    }
}
