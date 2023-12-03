package December_2023;

public class maxScore_1423 {
    // 逆向思维
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int m = n - k;
        int sum = 0;                    // 剩余牌的总和
        // 剩余牌必然是连续的
        for(int i = 0; i < m; i++){
            sum += cardPoints[i];
        }
        int total = sum;
        int min = sum;
        for(int i = m; i < n; i++){
            total += cardPoints[i];
            sum += cardPoints[i] - cardPoints[i - m];
            min = Math.min(min, sum);
        }
        return total - min;
    }

    // 正向思维
    public int maxScore2(int[] cardPoints, int k) {
        int sum = 0;
        int n = cardPoints.length;
        for(int i = 0; i < k; i++){
            sum += cardPoints[i];
        }
        int res = sum;
        for(int i = 1; i <= k; i++){
            // 前 k - i 个数之和 + 后 i 个数之和
            sum += cardPoints[n - i] - cardPoints[k - i];
            res = Math.max(sum, res);
        }
        return res;
    }
}
