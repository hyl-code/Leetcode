package April_2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

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
            while(used[++color[i]]);
        }
        return color;
    }
}
