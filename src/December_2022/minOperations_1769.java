package December_2022;

/*
    有 n 个盒子. 给你一个长度为 n 的二进制字符串 boxes, 其中 boxes[i] 的值为 '0' 表示第 i 个盒子是空的,
    而 boxes[i] 的值为 '1' 表示盒子里有一个小球.
    在一步操作中, 你可以将一个小球从某个盒子移动到一个与之相邻的盒子中.
    第 i 个盒子和第 j 个盒子相邻需满足 abs(i - j) == 1.
    注意, 操作执行后, 某些盒子中可能会存在不止一个小球.
    返回一个长度为 n 的数组 answer, 其中 answer[i] 是将所有小球移动到第 i 个盒子所需的最小操作数.
    每个 answer[i] 都需要根据盒子的初始状态进行计算.
 */
public class minOperations_1769 {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(boxes.charAt(j) == '1'){
                    res[i] += Math.abs(j - i);
                }
            }
        }
        return res;
    }
}
