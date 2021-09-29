package September_2021;

/*
    假设有 n 台超级洗衣机放在同一排上. 开始的时候, 每台洗衣机内可能有一定量的衣服, 也可能是空的.

    在每一步操作中, 你可以选择任意 m (1 <= m <= n) 台洗衣机, 与此同时将每台洗衣机的一件衣服送到相邻的一台洗衣机.

    给定一个整数数组 machines 代表从左至右每台洗衣机中的衣物数量, 请给出能让所有洗衣机中剩下的衣物的数量相等的最少的操作步数 .
    如果不能使每台洗衣机中衣物的数量相等, 则返回 -1 .
*/

//贪心算法

public class findMinMoves {
    public int findMinMoves(int[] machines) {
        int sum = 0;
        for(int i = 0; i < machines.length; i++){
            sum += machines[i];
        }
        if(sum % machines.length != 0)
            return -1;
        int ave = sum / machines.length;
        int res = 0, diff = 0;
        for(int i = 0; i < machines.length; i++){
            diff += machines[i] - ave;
            res = Math.max(res, Math.max(Math.abs(diff),machines[i] - ave));
        }
        /*
            Math.max(Math.abs(diff),machines[i] - ave)
            只能相邻之间操作, 但可以直接把需要减少的给到需要增加的里.
            例: 5 4 3 2 1
            machines[i] - ave表示另一种情况: 某个值特别大, 造成组 A 的值特别大.
         */
        return res;
    }
}
