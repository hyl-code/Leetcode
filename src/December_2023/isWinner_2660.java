package December_2023;

/*
    给你两个下标从 0 开始的整数数组 player1 和 player2, 分别表示玩家 1 和玩家 2 击中的瓶数.
    保龄球比赛由 n 轮组成, 每轮的瓶数恰好为 10.
    假设玩家在第 i 轮中击中 xi 个瓶子. 玩家第 i 轮的价值为：
        如果玩家在该轮的前两轮的任何一轮中击中了 10 个瓶子, 则为 2xi.
        否则, 为 xi.
    玩家的得分是其 n 轮价值的总和.
    返回
        如果玩家 1 的得分高于玩家 2 的得分, 则为 1 ;
        如果玩家 2 的得分高于玩家 1 的得分, 则为 2 ;
        如果平局, 则为 0.
 */
public class isWinner_2660 {
    public int isWinner(int[] player1, int[] player2) {
        int s1 = score(player1);
        int s2 = score(player2);
        return s1 == s2 ? 0 : s1 > s2 ? 1 : 2;
    }

    private int score(int[] player){
        int res = 0;
        for(int i = 0; i < player.length; i++){
            if((i > 0 && player[i - 1] == 10) || (i > 1 && player[i - 2] >= 10)){
                res += 2 * player[i];
            }else{
                res += player[i];
            }
        }
        return res;
    }
}
