package June_2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
    你有一个用于表示一片土地的整数矩阵 land, 该矩阵中每个点的值代表对应地点的海拔高度.
    若值为0则表示水域. 由垂直、水平或对角连接的水域为池塘. 池塘的大小是指相连接的水域的个数.
    编写一个方法来计算矩阵中所有池塘的大小, 返回值需要从小到大排序.
 */
public class pondSizes_16_19 {
    int[][] dirs = {{-1, 1}, {-1, -1}, {-1, 0}, {0, -1}, {0, 1}, {1, -1}, {1, 1}, {1, 0}};
    public int[] pondSizes(int[][] land) {
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < land.length; i++){
            for(int j = 0; j < land[0].length; j++){
                if(land[i][j] == 0){
                    cnt = dfs(land, new int[]{i, j});
                    list.add(cnt);
                }
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        Arrays.sort(res);
        return res;
    }

    public int dfs(int[][] land, int[] dir){
        if(dir[0] < 0 || dir[0] >= land.length || dir[1] < 0 || dir[1] >= land[0].length || land[dir[0]][dir[1]] != 0){
            return 0;
        }
        land[dir[0]][dir[1]] = -1;
        int cnt = 1;
        for(int i = 0; i < dirs.length; i++){
            int x = dir[0] + dirs[i][0], y = dir[1] + dirs[i][1];
            cnt += dfs(land, new int[]{x, y});
        }
        return cnt;
    }
}
