package September_2023;

import java.util.ArrayList;
import java.util.List;
/*
    在一个 8x8 的棋盘上, 放置着若干「黑皇后」和一个「白国王」.
    给定一个由整数坐标组成的数组 queens, 表示黑皇后的位置; 以及一对坐标 king, 表示白国王的位置, 返回所有可以攻击国王的皇后的坐标「任意顺序」.
 */
public class queensAttacktheKing_1222 {
    private final static int[][] dirs = {{1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}};

    // 站在国王的视角, 计算有哪些皇后能被国王「看到」
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        boolean[][] isQueen = new boolean[8][8];
        for(int[] q : queens){
            isQueen[q[0]][q[1]] = true;
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int[] dir : dirs){
            int x = king[0] + dir[0];
            int y = king[1] + dir[1];
            while(x >= 0 && x < 8 && y >= 0 && y < 8){
                if(isQueen[x][y]){
                    res.add(List.of(x, y));
                    break;
                }
                x += dir[0];
                y += dir[1];
            }
        }
        return res;
    }
}
