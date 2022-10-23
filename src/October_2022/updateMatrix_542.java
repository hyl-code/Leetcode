package October_2022;

import java.util.LinkedList;
import java.util.Queue;

/*
    给定一个由 0 和 1 组成的矩阵 mat, 请输出一个大小相同的矩阵, 其中每一个格子是 mat 中对应位置元素到最近的 0 的距离.
    两个相邻元素间的距离为 1.
 */
public class updateMatrix_542 {
    //左, 右, 上, 下
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<int[]>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int i = temp[0], j = temp[1];
            for(int k = 0; k < dir.length; k++){
                int ni = i + dir[k][0];
                int nj = j + dir[k][1];
                if(ni >= 0 && ni < m && nj >= 0 && nj < n && !visited[ni][nj]){
                    res[ni][nj] = res[i][j] + 1;
                    queue.offer(new int[]{ni, nj});
                    visited[ni][nj] = true;
                }
            }
        }
        return res;
    }
}
