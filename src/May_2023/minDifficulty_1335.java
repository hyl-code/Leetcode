package May_2023;

/*
    你需要制定一份 d 天的工作计划表. 工作之间存在依赖, 要想执行第 i 项工作, 你必须完成全部 j 项工作( 0 <= j < i).
    你每天至少需要完成一项任务. 工作计划的总难度是这 d 天每一天的难度之和, 而一天的工作难度是当天应该完成工作的最大难度.
    给你一个整数数组 jobDifficulty 和一个整数 d, 分别代表工作难度和需要计划的天数. 第 i 项工作的难度是 jobDifficulty[i].
    返回整个工作计划的最小难度. 如果无法制定工作计划, 则返回 -1.
*/
public class minDifficulty_1335 {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(d > n){
            return -1;
        }
        int[] f = new int[n];
        f[0] = jobDifficulty[0];
        for(int i = 1; i < n; i++){
            f[i] = Math.max(f[i - 1], jobDifficulty[i]);
        }
        for(int i = 1; i < d; i++){
            //记忆化搜索
            for(int j = n - 1; j >= i; j--){
                f[j] = Integer.MAX_VALUE;
                int max = 0;
                //将 [j, i] 分为一个区, 求这个区的最大值
                for(int k = j; k >= i; k--){
                    max = Math.max(max, jobDifficulty[k]);
                    //维护 f[j] 的最小值
                    f[j] = Math.min(f[j], f[k - 1] + max);
                }
            }
        }
        return f[n - 1];
    }
}
