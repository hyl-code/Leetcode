package October_2023;

import java.util.Arrays;
/*
    有一些机器人分布在一条无限长的数轴上, 他们初始坐标用一个下标从 0 开始的整数数组 nums 表示.
    当你给机器人下达命令时, 它们以每秒钟一单位的速度开始移动.
    给你一个字符串 s, 每个字符按顺序分别表示每个机器人移动的方向.
    'L' 表示机器人往左或者数轴的负方向移动, 'R' 表示机器人往右或者数轴的正方向移动.
    当两个机器人相撞时, 它们开始沿着原本相反的方向移动.
    请你返回指令重复执行 d 秒后, 所有机器人之间两两距离之和.
    由于答案可能很大, 请你将答案对 10^9 + 7 取余后返回.
 */
public class sumDistance_2731 {
    static final int MOD = 1000000007;
    // 机器人之间没有区别，相撞看作穿透，可以无视相撞
    public int sumDistance(int[] nums, String s, int d) {
        int n = nums.length;
        long[] pos = new long[n];
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == 'L'){
                pos[i] = (long) nums[i] - d;
            }else {
                pos[i] = (long) nums[i] + d;
            }
        }
        Arrays.sort(pos);
        long res = 0;
        for(int i = 1; i < n; i++){
            res += 1L * (pos[i] - pos[i - 1]) * i % MOD * (n - i) % MOD;
            res %= MOD;
        }
        return (int)res;
    }
}
