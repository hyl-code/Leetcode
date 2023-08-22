package August_2023;

/*
    给你一个数组 seats 表示一排座位, 其中 seats[i] = 1 代表有人坐在第 i 个座位上, seats[i] = 0 代表座位 i 上是空的（下标从 0 开始）.
    至少有一个空座位, 且至少有一人已经坐在座位上.
    亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上.
    返回他到离他最近的人的最大距离.
 */
public class maxDistToClosest_849 {
    // 模拟
    public int maxDistToClosest(int[] seats) {
        int n = seats.length, res = 0, pre = -1;
        for(int i = 0; i < n; i++){
            if(seats[i] == 1){
                // 特殊处理第一个 1
                if(pre == -1){
                    res = i;
                }else{
                    res = Math.max(res, (i - pre) / 2);
                }
                pre = i;
            }
        }
        // 特殊处理最后一个 1
        return Math.max(res, n - 1 - pre);
    }

    // 双指针 + 贪心
    public int maxDistToClosest2(int[] seats) {
        int res = 0, l = 0;
        while(l < seats.length && seats[l] == 0){
            l++;
        }
        // 特殊处理第一个 1
        res = Math.max(res, l);
        while(l < seats.length){
            int r = l + 1;
            while(r < seats.length && seats[r] == 0){
                r++;
            }
            // 特殊处理最后一个 1
            if(r == seats.length){
                res = Math.max(res, r - l - 1);
            }else{
                res = Math.max(res, (r - l) / 2);
            }
            l = r;
        }
        return res;
    }
}
