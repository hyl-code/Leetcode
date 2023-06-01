package June_2023;

import java.util.Arrays;

/*
    给你一个正整数数组 price, 其中 price[i] 表示第 i 类糖果的价格, 另给你一个正整数 k.
    商店组合 k 类不同糖果打包成礼盒出售. 礼盒的甜蜜度是礼盒中任意两种糖果价格绝对差的最小值.
    返回礼盒的最大甜蜜度.
 */
public class maximumTastiness_2517 {
    //二分法：下限为 0, 上限为 price[n - 1] - price[0].
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int left = 0, right = price[price.length - 1] - price[0];
        while(left < right){
            int mid = (left + right + 1) / 2;
            if(check(price, k, mid)){
                left = mid;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean check(int[] price, int k, int tastiness){
        int count = 0, prev = Integer.MIN_VALUE / 2;
        for(int p : price){
            if(p - prev >= tastiness){
                count++;
                prev = p;
            }
        }
        return count >= k;
    }
}
