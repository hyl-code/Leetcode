package November_2022;

/*
    在一根无限长的数轴上, 你站在 0 的位置. 终点在target的位置.
    你可以做一些数量的移动 numMoves :
        每次你可以选择向左或向右移动.
        第 i 次移动(从 i == 1 开始, 到 i == numMoves), 在选择的方向上走 i 步.
    给定整数target, 返回到达目标所需的最小移动次数(即最小 numMoves).
 */
public class reachNumber_754 {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int res = 0;
        while(target > 0){
            res++;
            target -= res;
        }
        return target % 2 == 0 ? res : res + 1 + res % 2;
    }
}
