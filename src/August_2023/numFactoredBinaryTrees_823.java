package August_2023;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*
    给出一个含有不重复整数元素的数组 arr, 每个整数 arr[i] 均大于 1.
    用这些整数来构建二叉树, 每个整数可以使用任意次数.
    其中：每个非叶结点的值应等于它的两个子结点的值的乘积.
    满足条件的二叉树一共有多少个？答案可能很大, 返回 对 10^9 + 7 取余 的结果.
 */
public class numFactoredBinaryTrees_823 {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        final long mod = 1000000007;
        Map<Integer, Long> map = new HashMap<>();
        for(int i : arr){
            map.put(i, 1l);
        }
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j <= i; j++){
                if(1l * arr[i] * arr[j] <= arr[arr.length - 1]){
                    if(map.containsKey(arr[i] * arr[j])){
                        if(i == j){
                            map.put(arr[i] * arr[j], (map.get(arr[i]) * map.get(arr[j]) + map.get(arr[i] * arr[j])) % mod);
                        }else{
                            map.put(arr[i] * arr[j], (2 * map.get(arr[i]) * map.get(arr[j]) + map.get(arr[i] * arr[j])) % mod);
                        }
                    }
                }
            }
        }
        long rtu = 0;
        for(int i : arr){
            rtu += map.get(i);
            rtu %= mod;
        }
        return (int)rtu;
    }
}
