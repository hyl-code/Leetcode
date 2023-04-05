package April_2023;
import java.util.Arrays;

/*
    有 N 堆石头排成一排, 第 i 堆中有 stones[i] 块石头.
    每次移动 (move) 需要将连续的 K 堆石头合并为一堆, 而这个移动的成本为这 K 堆石头的总数.
    找出把所有石头合并成一堆的最低成本. 如果不可能, 返回 -1.
 */
public class mergeStones_1000 {
    int[][] memo;
    int[] s;
    int k;
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        // 从n 堆变成 1 堆, 需要减少 n−1 堆, 而每次合并都会减少 k−1 堆, 所以 n−1 必须是 k−1 的倍数.
        if((n - 1) % (k - 1) > 0){
            return -1;
        }
        s = new int[n + 1];
        for(int i = 0; i < n; i++){
            s[i + 1] = s[i] + stones[i];
        }
        this.k = k;
        memo = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, n - 1);
    }

    public int dfs(int i, int j){
        if(i == j){
            return 0;
        }
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        int res = Integer.MAX_VALUE;
        for(int m = i; m < j; m += (k - 1)){
            res = Math.min(res, dfs(i, m) + dfs(m + 1, j));
        }
        // 对于 dfs(i, j, 1)来说, j - i 必是 k - 1 的倍数.
        if((j - i) % (k - 1) == 0){
            res += (s[j + 1] - s[i]);
        }
        memo[i][j] = res;
        return memo[i][j];
    }
}
