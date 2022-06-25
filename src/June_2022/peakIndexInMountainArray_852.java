package June_2022;

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
