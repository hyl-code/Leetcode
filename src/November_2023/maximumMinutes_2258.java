package November_2023;

import java.util.ArrayList;
import java.util.List;
/*
    给你一个下标从 0 开始大小为 m x n 的二维整数数组 grid, 它表示一个网格图.
    每个格子为下面 3 个值之一：
        0 表示草地.
        1 表示着火的格子.
        2 表示一座墙, 你跟火都不能通过这个格子.
    一开始你在最左上角的格子 (0, 0), 你想要到达最右下角的安全屋格子 (m - 1, n - 1).
    每一分钟, 你可以移动到相邻的草地格子. 每次你移动之后, 着火的格子会扩散到所有不是墙的相邻格子.
    请你返回你在初始位置可以停留的最多分钟数, 且停留完这段时间后你还能安全到达安全屋. 如果无法实现, 请你返回 -1.
    如果不管你在初始位置停留多久, 你总是能到达安全屋, 请你返回 10^9.
    注意, 如果你到达安全屋后, 火马上到了安全屋, 这视为你能够安全到达安全屋.
    如果两个格子有共同边, 那么它们为相邻格子.
 */
public class maximumMinutes_2258 {
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maximumMinutes(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int left = -1, right = m * n + 1;
        while(left + 1 < right){
            int mid = (left + right) >>> 1;
            if(check(grid, mid)){
                left = mid;
            }else{
                right = mid;
            }
        }
        return left < m * n ? left : 1000000000;
    }

    // 返回能否在初始位置停留 t 分钟, 并安全到达安全屋
    private boolean check(int[][] grid, int t){
        int m = grid.length, n = grid[0].length;
        boolean[][] onFire = new boolean[m][n];
        List<int[]> f = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    onFire[i][j] = true;        // 标记着火的位置
                    f.add(new int[]{i, j});
                }
            }
        }
        while(t-- > 0 && !f.isEmpty()){         // 如果火无法扩散就提前退出
            f = spreadFire(grid, onFire, f);    // 火扩散
        }
        if(onFire[0][0]){
            return false;                       // 起点着火
        }

        // 人的 BFS
        boolean[][] vis = new boolean[m][n];
        vis[0][0] = true;
        List<int[]> q = List.of(new int[]{0, 0});
        while(!q.isEmpty()){
            List<int[]> tmp = q;
            q = new ArrayList<>();
            for(int[] p : tmp){
                if(onFire[p[0]][p[1]]){         // 人走到这个位置后，火也扩散到这个位置
                    continue;
                }
                for(int[] d : dirs){            // 枚举上下左右四个方向
                    int x = p[0] + d[0], y = p[1] + d[1];
                    if(x >= 0 && x < m && y >=0 && y < n && !onFire[x][y] && !vis[x][y] && grid[x][y] == 0){
                        if(x == m - 1 && y == n - 1){
                            return true;        // 暂时安全了
                        }
                        vis[x][y] = true;       // 避免重复访问同一位置
                        q.add(new int[]{x, y});
                    }
                }
            }
            f = spreadFire(grid, onFire, f);    // 火扩散
        }
        return false;                           //人被火烧到，或者没有可以到达安全屋的路
    }

    // 火的 BFS
    private List<int[]> spreadFire(int[][] grid, boolean[][] fire, List<int[]> f){
        int m = grid.length, n = grid[0].length;
        List<int[]> tmp = f;
        f = new ArrayList<>();
        for(int[] p : tmp){
            for(int[] d : dirs){                // 枚举上下左右四个方向
                int x = p[0] + d[0], y = p[1] + d[1];
                if(x >= 0 && x < m && y >=0 && y < n && !fire[x][y] && grid[x][y] == 0){
                    fire[x][y] = true;          // 标记着火的位置
                    f.add(new int[]{x, y});
                }
            }
        }
        return f;
    }
}
