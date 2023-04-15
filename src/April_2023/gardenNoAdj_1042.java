package April_2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    有 n 个花园, 按从 1 到 n 标记. 另有数组 paths, 其中 paths[i] = [xi, yi] 描述了花园 xi 到花园 yi 的双向路径.
    在每个花园中, 你打算种下四种花之一. 另外，所有花园最多有 3 条路径可以进入或离开.
    你需要为每个花园选择一种花,使得通过路径相连的任何两个花园中的花的种类互不相同.
    以数组形式返回任一可行的方案作为答案 answer, 其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类.
    花的种类用 1, 2, 3, 4 表示. 保证存在答案.
 */
public class gardenNoAdj_1042 {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] graph = new ArrayList[n];
        Arrays.setAll(graph, path -> new ArrayList<>());
        for(int[] path : paths){
            int x = path[0] - 1, y = path[1] - 1;
            graph[x].add(y);
            graph[y].add(x);
        }
        int[] color = new int[n];
        for(int i = 0; i < n; i++){
            boolean[] used = new boolean[5];
            for(int j : graph[i]){
                used[color[j]] = true;
            }
            // 当 used[color[i]] == false 时, 则找到 color 为同种类花所处花园不相邻
            while(used[color[i]]){
                color[i]++;
            }
        }
        return color;
    }
}
