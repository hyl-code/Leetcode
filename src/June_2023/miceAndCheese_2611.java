package June_2023;

import java.util.Arrays;
/*
    有两只老鼠和 n 块不同类型的奶酪, 每块奶酪都只能被其中一只老鼠吃掉.
    下标为 i 处的奶酪被吃掉的得分为：
        如果第一只老鼠吃掉, 则得分为 reward1[i].
        如果第二只老鼠吃掉, 则得分为 reward2[i].
        给你一个正整数数组 reward1, 一个正整数数组 reward2, 和一个非负整数 k.
    请你返回第一只老鼠恰好吃掉 k 块奶酪的情况下, 最大得分为多少.
 */
public class miceAndCheese_2611 {
    //贪心：先把 reward1 的值全部相加放到 res 中, 再遍历求 reward2[i] - reward[i] 的值得到他们之间的差.
    //     对 sub 进行从小到大排序后，将 res 与 sub[k] 及以后的差值相加, 得到最大得分.
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        int res = 0;
        int[] sub = new int[n];
        for(int i = 0;i < n; i++){
            sub[i] = reward2[i] - reward1[i];
            res += reward1[i];
        }
        Arrays.sort(sub);
        for(int i = k; i < n; i++){
            res += sub[i];
        }
        return res;
    }
}
