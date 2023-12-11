package December_2023;

import java.util.LinkedList;
import java.util.Queue;
/*
    你准备参加一场远足活动. 给你一个二维 rows x columns 的地图 heights, 其中 heights[row][col] 表示格子 (row, col) 的高度.
    一开始你在最左上角的格子 (0, 0), 且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）.
    你每次可以往上、下、左、右四个方向之一移动, 你想要找到耗费体力最小的一条路径.
    一条路径耗费的体力值是路径上相邻格子之间高度差绝对值的最大值决定的.
    请你返回从左上角走到右下角的最小体力消耗值.
 */
public class minimumEffortPath_1631 {
    // BFS
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int left = 0, right = 999999, res = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            Queue<int[]> queue = new LinkedList<int[]>();
            queue.offer(new int[]{0, 0});
            boolean[] seen = new boolean[m * n];
            seen[0] = true;
            while(!queue.isEmpty()){
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];
                for(int i = 0; i < 4; i++){
                    int nx = x + dirs[i][0];
                    int ny = y + dirs[i][1];
                    if(nx >= 0 && nx < m && ny >= 0 && ny < n && !seen[nx * n + ny] && Math.abs(heights[x][y] - heights[nx][ny]) <= mid){
                        queue.offer(new int[]{nx, ny});
                        seen[nx * n + ny] = true;
                    }
                }
            }
            if(seen[m * n - 1]){
                res = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return res;
    }
}
