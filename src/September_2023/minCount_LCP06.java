package September_2023;

/*
    桌上有 n 堆力扣币, 每堆的数量保存在数组 coins 中.
    我们每次可以选择任意一堆, 拿走其中的一枚或者两枚, 求拿完所有力扣币的最少次数.
 */
public class minCount_LCP06 {
    public int minCount(int[] coins) {
        int res = 0;
        for (int coin : coins) {
            res += (coin + 1) / 2;
        }
        return res;
    }
}
