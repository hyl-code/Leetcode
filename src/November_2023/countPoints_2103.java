package November_2023;

/*
    总计有 n 个环, 环的颜色可以是红、绿、蓝中的一种. 这些环分别穿在 10 根编号为 0 到 9 的杆上.
    给你一个长度为 2n 的字符串 rings, 表示这 n 个环在杆上的分布.
    rings 中每两个字符形成一个颜色位置对, 用于描述每个环：
        第 i 对中的第一个字符表示第 i 个环的颜色（'R'、'G'、'B'）.
        第 i 对中的第二个字符表示第 i 个环的位置, 也就是位于哪根杆上（'0' 到 '9'）.
    例如, "R3G2B1" 表示：共有 n == 3 个环, 红色的环在编号为 3 的杆上, 绿色的环在编号为 2 的杆上, 蓝色的环在编号为 1 的杆上.
    找出所有集齐全部三种颜色环的杆, 并返回这种杆的数量.
 */
public class countPoints_2103 {
    static final int POLE_NUM = 10;
    static final int COLOR_NUM = 3;

    public int c(String rings) {
        int[][] state = new int[POLE_NUM][COLOR_NUM];
        int n = rings.length();
        for(int i = 0; i < n; i += 2){
            char color = rings.charAt(i);
            int poleIndex = rings.charAt(i + 1) - '0';
            state[poleIndex][getColorId(color)] = 1;
        }
        int res = 0;
        for(int i = 0; i < POLE_NUM; i++){
            boolean flag = true;
            for(int j = 0; j < COLOR_NUM; j++){
                if(state[i][j] == 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                res++;
            }
        }
        return res;
    }

    public int getColorId(char color){
        if(color == 'R'){
            return 0;
        }else if(color == 'G'){
            return 1;
        }
        return 2;
    }
}
