package May_2023;

import java.util.LinkedList;
import java.util.Queue;

/*
    给你一个 n x n 的二进制矩阵 grid 中, 返回矩阵中最短畅通路径的长度. 如果不存在这样的路径, 返回 -1.
    二进制矩阵中的畅通路径是一条从左上角单元格（即, (0, 0)）到右下角单元格（即, (n - 1, n - 1)）的路径, 该路径同时满足下述要求：
        路径途经的所有单元格的值都是 0.
        路径中所有相邻的单元格应当在 8 个方向之一上连通 (即, 相邻两单元之间彼此不同且共享一条边或者一个角).
    畅通路径的长度是该路径途经的单元格总数.
 */
public class shortestPathBinaryMatrix_1091 {
    //定义 8 个方向
    int[][] dir = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return -1;
        }
        //起点阻塞, 直接返回 -1.
        if(grid[0][0] == 1){
            return -1;
        }
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});     //把起点放进队列里
        grid[0][0] = 1;                 //把起点标记为阻塞, 即已被访问
        int path = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];
                //如果等于终点, 则说明可以返回了
                if(x == n - 1 && y == n - 1){
                    return path;
                }
                for(int[] d : dir){
                    int x1 = x + d[0];
                    int y1 = y + d[1];
                    //过滤溢出值
                    if(x1 < 0 || x1 >= n || y1 < 0 || y1 >= n || grid[x1][y1] == 1){
                        continue;
                    }
                    //把在数组范围内, 并且未访问的放入队列中
                    queue.add(new int[]{x1, y1});
                    grid[x1][y1] = 1;       //标记为阻塞
                }
            }
            path++;
        }
        return -1;
    }
}
