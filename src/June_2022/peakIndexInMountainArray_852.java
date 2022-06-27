package June_2022;

/*
    符合下列属性的数组 arr 称为 山脉数组 ：
    arr.length >= 3
    存在 i（0 < i < arr.length - 1）使得：
    arr[0] < arr[1] < ... arr[i-1] < arr[i]
    arr[i] > arr[i+1] > ... > arr[arr.length - 1]
    给你由整数组成的山脉数组 arr ,
    返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i .
 */

public class peakIndexInMountainArray_852 {
    //当 i < ians 时, arri < arri+1 恒成立;
    //当 i ≥ ians时, arri >arri+1 恒成立 .
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 2;
        int res = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] > arr[mid + 1]){
                right = mid - 1;
                res = mid;
            }else{
                left = mid + 1;
            }
        }
        return res;
    }

    public int peakIndexInMountainArray2(int[] arr) {
        int left = 0, right = arr.length;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]){
                return mid;
            }
            if(arr[mid] < arr[mid + 1]){
                left = mid;
            }else if(arr[mid] > arr[mid + 1]){
                right = mid;
            }
        }
        return right;
    }
}
