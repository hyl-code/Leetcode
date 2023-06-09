package June_2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    给你一个 n 个节点的无向带权连通图, 节点编号为 0 到 n - 1, 再给你一个整数数组 edges,
    其中 edges[i] = [ai, bi, wi] 表示节点 ai 和 bi 之间有一条边权为 wi 的边.
    部分边的边权为 -1（wi = -1）, 其他边的边权都为正数（wi > 0）.
    你需要将所有边权为 -1 的边都修改为范围 [1, 2 * 109] 中的正整数, 使得从节点 source 到节点 destination 的最短距离为整数 target.
    如果有多种修改方案可以使 source 和 destination 之间的最短距离等于 target, 你可以返回任意一种方案.
    如果存在使 source 到 destination 最短距离为 target 的方案, 请你按任意顺序返回包含所有边的数组（包括未修改边权的边）.
    如果不存在这样的方案, 请你返回一个空数组.
    注意：你不能修改一开始边权为正数的边.
 */
public class modifiedGraphEdges_2699 {
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        List<int[]> g[] = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        //建图
        for(int i = 0; i < edges.length; i++){
            int x = edges[i][0], y = edges[i][1];
            g[x].add(new int[]{y, i});
            g[y].add(new int[]{x, i});
        }
        int[][] dis = new int[n][2];
        for(int i = 0; i < n; i++){
            if(i != source){
                dis[i][0] = dis[i][1] = Integer.MAX_VALUE;
            }
        }
        dijkstra(g, edges, destination, dis, 0, 0);
        int delta = target - dis[destination][0];
        // -1 全部改为 1 后, 最短路比 target 还大.
        if(delta < 0){
            return new int[][]{};
        }
        dijkstra(g, edges, destination, dis, delta, 1);
        //最短路无法再变大, 无法达到 target.
        if(dis[destination][1] < target){
            return new int[][]{};
        }
        //剩余没修改并且无影响的边全部改为 1.
        for(var e : edges){
            if(e[2] == -1){
                e[2] = 1;
            }
        }
        return edges;
    }

    // Dijkstra 算法, k 标识第一次/第二次
    private void dijkstra(List<int[]> g[], int[][] edges, int destination, int[][] dis, int delta, int k){
        int n = g.length;
        boolean[] visited = new boolean[n];
        for( ; ; ){
            int x = -1;
            for(int i = 0; i < n; i++){
                if(!visited[i] && (x < 0 || dis[i][k] < dis[x][k])){
                    x = i;
                }
            }
            if(x == destination){
                return;
            }
            visited[x] = true;
            for(var e : g[x]){
                int y = e[0], eid = e[1];
                int wt = edges[eid][2];
                // -1 改为 1
                if(wt == -1){
                    wt = 1;
                }
                //第二次 Dijkstra, 改为 w.
                if(k == 1 && edges[eid][2] == -1){
                    int w = delta + dis[y][0] - dis[x][1];
                    if(w > wt){
                        edges[eid][2] = wt = w;
                    }
                }
                dis[y][k] = Math.min(dis[y][k], dis[x][k] + wt);
            }
        }
    }
}
