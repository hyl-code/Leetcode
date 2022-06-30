package June_2022;

/*
    给你一个 严格升序排列 的正整数数组 arr 和一个整数 k .

    请你找到这个数组里第 k 个缺失的正整数 .
 */

public class findKthPositive_1539 {
    public int findKthPositive(int[] arr, int k) {
        for(int num : arr){
            //当arr数组为空或数组中的数都小于k时
            if(num <= k){
                k++;
            }else {
                break;
            }
        }
        return k;
    }
}
