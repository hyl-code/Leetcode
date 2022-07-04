package July_2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    给你个整数数组 arr , 其中每个元素都不相同 .
    请你找到所有具有最小绝对差的元素对, 并且按升序的顺序返回 .
 */

public class minimumAbsDifference_1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        int num = arr[1] - arr[0];
        for(int i = 1; i < arr.length - 1; i++){
            if(arr[i + 1] - arr[i] < num){
                num = arr[i + 1] - arr[i];
            }
        }
        for(int i = 0; i < arr.length - 1; i++){
            List<Integer> list = new ArrayList<>();
            if(arr[i + 1] - arr[i] == num){
                list.add(arr[i]);
                list.add(arr[i + 1]);
                res.add(list);
            }
        }
        return res;
    }
}
