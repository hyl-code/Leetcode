package May_2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    给你一棵由 n 个顶点组成的无向树, 顶点编号从 1 到 n. 青蛙从顶点 1 开始起跳. 规则如下：
        在一秒内, 青蛙从它所在的当前顶点跳到另一个未访问过的顶点 (如果它们直接相连).
        青蛙无法跳回已经访问过的顶点.
        如果青蛙可以跳到多个不同顶点, 那么它跳到其中任意一个顶点上的机率都相同.
        如果青蛙不能跳到任何未访问过的顶点上, 那么它每次跳跃都会停留在原地.
        无向树的边用数组 edges 描述, 其中 edges[i] = [ai, bi] 意味着存在一条直接连通 ai 和 bi 两个顶点的边.
    返回青蛙在 t 秒后位于目标顶点 target 上的概率. 与实际答案相差不超过 10-5 的结果将被视为正确答案.
 */
public class frogPosition_1377 {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<Integer>[] g = new ArrayList[n + 1];
        Arrays.setAll(g, e -> new ArrayList<>());
        g[1].add(0);        //减少特殊情况额外判断的操作
        //建树
        for(int[] edge : edges){
            int x = edge[0], y = edge[1];
            g[x].add(y);
            g[y].add(x);
        }
        long prod = dfs(g, target, 1, 0, t);
        return prod != 0 ? 1.0 / prod : 0;
    }

    private long dfs(List<Integer>[] g, int target, int x, int fa, int leftT){
        // t 秒后在 target（恰好到达或青蛙停在原地)
        if(leftT == 0){
            return x == target ? 1 : 0;
        }
        if(x == target){
            return g[x].size() == 1 ? 1 : 0;
        }
        for(int y : g[x]){      // 遍历 x 的儿子 y
            if(y != fa){        // y 不能为父节点
                long prod = dfs(g, target, y, x, leftT - 1);    //寻找 target
                if(prod != 0){
                    return prod * (g[x].size() - 1);    //与儿子个数相乘后返回
                }
            }
        }
        return 0;
    }
}
