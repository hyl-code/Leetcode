package October_2022;

import java.util.Deque;
import java.util.LinkedList;

/*
    给定一个整数数组 arr, 找到 min(b) 的总和, 其中 b 的范围为 arr 的每个(连续)子数组.
    由于答案可能很大, 因此返回答案模 10^9 + 7.
 */
public class sumSubarrayMins_907 {
    private int mod = 1000000007;
    //暴力法
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int res = 0;
        for(int i = 0; i < n; i++){
            int min = arr[i];
            for(int j = i; j < n; j++){
                min = Math.min(min, arr[j]);
                res = (res + min) % mod;
            }
        }
        return res;
    }

    //以下标为标志, 为每一个数寻找左、右边界
    public int sumSubarrayMins2(int[] arr) {
        int n = arr.length;
        long res = 0;
        Deque<Integer> deque = new LinkedList<>();
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i = 0; i < n; i++){
            while(!deque.isEmpty() && arr[deque.peek()] > arr[i]){
                deque.pop();
            }
            if(deque.isEmpty()){
                left[i] = -1;
            }else{
                left[i] = deque.peek();
            }
            deque.push(i);
        }
        deque.clear();
        for(int i = n - 1; i >= 0; i--){
            //'>=' 是为解决两个最小值的情况
            while(!deque.isEmpty() && arr[deque.peek()] >= arr[i]){
                deque.pop();
            }
            if(deque.isEmpty()){
                right[i] = n;
            }else{
                right[i] = deque.peek();
            }
            deque.push(i);
        }
        for(int i = 0; i < n; i++){
            //(i - left[i]) * (right[i] - i) 就是 arr[i] 的贡献次数
            res = (res + (long)(i - left[i]) * (right[i] - i) * arr[i]) % mod;
        }
        return (int)res;
    }
}
