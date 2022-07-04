package July_2022;

import java.util.Arrays;

/*
    给你一个整数数组 arr, 请你检查是否存在两个整数 N 和 M, 满足 N 是 M 的两倍（即, N = 2 * M）.

    更正式地, 检查是否存在两个下标 i 和 j 满足:
        i != j
        0 <= i, j < arr.length
        arr[i] == 2 * arr[j]
 */

public class checkIfExist_1346 {
    //暴力法 yyds
    public boolean checkIfExist(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            int num = arr[i] * 2;
            for(int j = 0; j < arr.length; j++){
                if(arr[j] == num && i != j)
                    return true;
            }
        }
        return false;
    }

    //二分法
    public boolean checkIfExist2(int[] arr) {
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            int left = 0, right = arr.length - 1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(arr[mid] == arr[i] * 2 && mid != i){
                    return true;
                }else if(arr[mid] > arr[i] * 2){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            left = 0;
            right = arr.length - i - 1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(arr[mid] == arr[i] * 2 && mid != i){
                    return true;
                }else if(arr[mid] > arr[i] * 2){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}
