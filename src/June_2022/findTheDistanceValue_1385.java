package June_2022;

import java.util.Arrays;

/*
    给你两个整数数组 arr1 , arr2 和一个整数 d , 请你返回两个数组之间的距离值 .

    「距离值」定义为符合此距离要求的元素数目：对于元素 arr1[i] , 不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d .
 */

public class findTheDistanceValue_1385 {
    //二分法
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int res = 0;
        Arrays.sort(arr2);
        for(int num : arr1){
            //num - d < arr1[i] < num + d
            int low = num - d, high = num + d;
            if(!binarySearch(arr2, low, high)){
                res++;
            }
        }
        return res;
    }

    public boolean binarySearch(int arr[], int low, int high){
        int left = 0, right = arr.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] >= low && arr[mid] <= high){
                return true;
            }else if(arr[mid] < low){
                left = mid + 1;
            }else if(arr[mid] > high){
                right = mid - 1;
            }
        }
        return false;
    }

    //暴力法
    public int findTheDistanceValue2(int[] arr1, int[] arr2, int d) {
        int res = 0;
        int n = arr2.length;
        for(int num : arr1){
            int temp = 0;
            for(int i = 0; i < n; i++){
                if(Math.abs(num - arr2[i]) > d)
                    temp++;
            }
            if(temp == n){
                res++;
                temp = 0;
            }
        }
        return res;
    }
}
