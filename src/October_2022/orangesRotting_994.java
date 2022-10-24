package October_2022;

import java.util.LinkedList;
import java.util.Queue;

/*
    在给定的 m x n 网格 grid 中, 每个单元格可以有以下三个值之一:
    值 0 代表空单元格;
    值 1 代表新鲜橘子;
    值 2 代表腐烂的橘子.
    每分钟, 腐烂的橘子周围 4 个方向上相邻的新鲜橘子都会腐烂.
    返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数. 如果不可能, 返回 -1.
 */
public class orangesRotting_994 {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        //记录新鲜橘子个数
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    //将腐烂的橘子入列
                    queue.offer(i * n + j);
                }else if(grid[i][j] == 1){
                    cnt++;
                }
            }
        }
        int time = 0;
        while(!queue.isEmpty() && cnt > 0){
            time++;
            int size =  queue.size();
            for(int i = 0; i < size; i++){
                int p = queue.poll();
                // x 表示行, y 表示列
                int x = p / n, y = p % n;
                //上
                if(x - 1 >= 0 && grid[x - 1][y] == 1){
                    cnt--;
                    grid[x - 1][y] = 2;
                    queue.offer((x - 1) * n + y);
                }
                //下
                if(x + 1 < m && grid[x + 1][y] == 1){
                    cnt--;
                    grid[x + 1][y] = 2;
                    queue.offer((x + 1) * n + y);
                }
                //左
                if(y - 1 >= 0 && grid[x][y - 1] == 1){
                    cnt--;
                    grid[x][y - 1] = 2;
                    queue.offer(x * n + y - 1);
                }
                //右
                if(y + 1 < n && grid[x][y + 1] == 1){
                    cnt--;
                    grid[x][y + 1] = 2;
                    queue.offer(x * n + y + 1);
                }
            }
        }
        return cnt == 0 ? time : -1;
    }
}
