package November_2022;
import java.util.*;

/*
    给定一个二维网格 grid, 其中:
        '.' 代表一个空房间
        '#' 代表一堵
        '@' 是起点
        小写字母代表钥匙
        大写字母代表锁
    我们从起点开始出发, 一次移动是指向四个基本方向之一行走一个单位空间.我们不能在网格外面行走, 也无法穿过一堵墙.
    如果途经一个钥匙, 我们就把它捡起来. 除非我们手里有对应的钥匙, 否则无法通过锁.
    假设 k 为 钥匙/锁 的个数, 且满足 1 <= k <= 6, 字母表中的前 k 个字母在网格中都有自己对应的一个小写和一个大写字母.
    换言之, 每个锁有唯一对应的钥匙, 每个钥匙也有唯一对应的锁. 另外, 代表钥匙和锁的字母互为大小写并按字母顺序排列.
    返回获取所有钥匙所需要的移动的最少次数. 如果无法获取所有钥匙, 返回 -1.
 */
public class shortestPathAllKeys_864 {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();
        //起始点: (sx, sy)
        int sx = 0, sy = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        //遍历 -> 初始化起点, 初始化 map
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i].charAt(j) == '@') {
                    sx = i;
                    sy = j;
                } else if (Character.isLowerCase(grid[i].charAt(j))) {
                    if (!map.containsKey(grid[i].charAt(j))) {
                        int idx = map.size();
                        map.put(grid[i].charAt(j), idx);
                    }
                }
            }
        }
        Queue<int[]> queue = new ArrayDeque<int[]>();
        //三元组: m, n 分别代表该位置上的 x, y;
        //  mask 是一个二进制数,长度恰好等于网格中钥匙的数目，
        //  当我们获得了网格中的第 i 把钥匙, mask 的第 i 个二进制位为 1.
        int[][][] dist = new int[m][n][1 << map.size()];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                Arrays.fill(dist[i][j], -1);
            }
        }
        queue.offer(new int[]{sx, sy, 0});
        dist[sx][sy][0] = 0;
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int x = arr[0], y = arr[1], mask = arr[2];
            for (int i = 0; i < 4; ++i) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx].charAt(ny) != '#') {
                    if (grid[nx].charAt(ny) == '.' || grid[nx].charAt(ny) == '@') {
                        //从起点出发或走到空房间时
                        if (dist[nx][ny][mask] == -1) {
                            dist[nx][ny][mask] = dist[x][y][mask] + 1;
                            queue.offer(new int[]{nx, ny, mask});
                        }
                    } else if (Character.isLowerCase(grid[nx].charAt(ny))) {
                        //当遇到钥匙时
                        int idx = map.get(grid[nx].charAt(ny));
                        if (dist[nx][ny][mask | (1 << idx)] == -1) {
                            dist[nx][ny][mask | (1 << idx)] = dist[x][y][mask] + 1;
                            if ((mask | (1 << idx)) == (1 << map.size()) - 1) {
                                return dist[nx][ny][mask | (1 << idx)];
                            }
                            queue.offer(new int[]{nx, ny, mask | (1 << idx)});
                        }
                    } else {
                        //当遇到锁时
                        int idx = map.get(Character.toLowerCase(grid[nx].charAt(ny)));
                        if ((mask & (1 << idx)) != 0 && dist[nx][ny][mask] == -1) {
                            dist[nx][ny][mask] = dist[x][y][mask] + 1;
                            queue.offer(new int[]{nx, ny, mask});
                        }
                    }
                }
            }
        }
        return -1;
    }
}
