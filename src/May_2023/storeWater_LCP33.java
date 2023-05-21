package May_2023;

import java.util.Arrays;

/*
    给定 N 个无限容量且初始均空的水缸, 每个水缸配有一个水桶用来打水, 第 i 个水缸配备的水桶容量记作 bucket[i].
    小扣有以下两种操作：
        升级水桶：选择任意一个水桶, 使其容量增加为 bucket[i]+1
        蓄水：将全部水桶接满水, 倒入各自对应的水缸
        每个水缸对应最低蓄水量记作 vat[i], 返回小扣至少需要多少次操作可以完成所有水缸蓄水要求.
    注意：实际蓄水量达到或超过最低蓄水量, 即完成蓄水要求.
 */
public class storeWater_LCP33 {
    //贪心
    public int storeWater(int[] bucket, int[] vat) {
        int maxk = Arrays.stream(vat).max().getAsInt();
        if(maxk == 0){
            return 0;
        }
        int res = Integer.MAX_VALUE;
        //设最终需要蓄水的次数为 k, 那么对于第 i 个水缸升级水桶次数： mi = [vat[i]/k] = (vat[i] + k - 1) / k, 遍历完得到它们的和 m
        //总操作数：m + k
        //依次遍历, 维护 res 最小值
        for(int k = 1; k <= maxk && k < res; k++){
            int m = 0;
            for(int i = 0; i < bucket.length; i++){
                m += Math.max(0, (vat[i] + k - 1) / k - bucket[i]);
            }
            res = Math.min(res, m + k);
        }
        return res;
    }
}
