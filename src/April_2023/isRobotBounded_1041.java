package April_2023;

/*
    在无限的平面上, 机器人最初位于 (0, 0) 处， 面朝北方. 注意:
        北方向是 y 轴的正方向.
        南方向是 y 轴的负方向.
        东方向是 x 轴的正方向.
        西方向是 x 轴的负方向.
    机器人可以接受下列三条指令之一:
        "G": 直走 1 个单位
        "L": 左转 90 度
        "R": 右转 90 度
    机器人按顺序执行指令 instructions, 并一直重复它们.
    只有在平面中存在环使得机器人永远无法离开时, 返回 true. 否则, 返回 false.
 */
public class isRobotBounded_1041 {
    public boolean isRobotBounded(String instructions) {
        int[][] vecs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[] loc = new int[2];
        int index = 0;
        for(char c : instructions.toCharArray()){
            if(c == 'G'){
                loc[0] += vecs[index][0];
                loc[0] += vecs[index][1];
            }else if(c =='L'){
                index = (index + 3) % 4;
            }else{
                index = (index + 1) % 4;
            }
        }
        //如果面朝方向与原方向垂直或相反, 那么循环有限次后能够回到原点
        //(垂直: 四个向量大小相等, 组成正方形; 相反: 两个向量大小相等, 方向相反)
        //如果面朝方向不变, 向量不是零则发散, 是零则一直在原点.
        if(index == 0){
            return loc[0] == 0 && loc[1] == 0;
        }
        return true;
    }
}
