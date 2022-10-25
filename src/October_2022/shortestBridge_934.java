package October_2022;

import java.util.ArrayDeque;
import java.util.Queue;

/*
    给你一个大小为 n x n 的二元矩阵 grid, 其中 1 表示陆地, 0 表示水域.
    岛是由四面相连的 1 形成的一个最大组, 即不会与非组内的任何其他 1 相连.
    grid 中恰好存在两座岛.
    你可以将任意数量的 0 变为 1, 以使两座岛连接起来, 变成 一座岛.
    返回必须翻转的 0 的最小数目.
 */

public class shortestBridge_934 {
/*
    通过遍历找到数组 grid 中的 1 后进行深度优先搜索, 此时可以得到第一座岛的位置集合, 记为 island,
        并将其位置全部标记为 −1.
    随后我们从 island 中的所有位置开始进行广度优先搜索, 当它们到达了任意的 1 时,
        即表示搜索到了第二个岛, 搜索的层数就是答案.
 */
    int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    //DFS + BFS
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    Queue<int[]> queue = new ArrayDeque<int[]>();
                    dfs(grid, i, j, queue);
                    int step = 0;
                    while(!queue.isEmpty()){
                        int size = queue.size();
                        for(int k = 0; k < size; k++){
                            int[] cell = queue.poll();
                            int x = cell[0], y = cell[1];
                            for(int d = 0; d < 4; d++){
                                int nx = x + dir[d][0];
                                int ny = y + dir[d][1];
                                if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                                    if(grid[nx][ny] == 0){
                                        queue.offer(new int[]{nx, ny});
                                        grid[nx][ny] = -1;
                                    }else if(grid[nx][ny] == 1){
                                        return step;
                                    }
                                }
                            }
                        }
                        step++;
                    }
                }
            }
        }
        return 0;
    }

    public void dfs(int[][] grid, int i, int j, Queue<int[]> queue){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1){
            return;
        }
        queue.offer(new int[]{i, j});
        grid[i][j] = -1;
        dfs(grid, i - 1, j, queue);
        dfs(grid, i + 1, j, queue);
        dfs(grid, i, j - 1, queue);
        dfs(grid, i, j + 1, queue);
    }
}
