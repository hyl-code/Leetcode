package October_2022;

/*
    给定一个长度为 n 的整数数组 arr, 它表示在 [0, n - 1] 范围内的整数的排列.
    我们将 arr 分割成若干块(即分区), 并对每个块单独排序.
    将它们连接起来后, 使得连接的结果和按升序排序后的原数组相同.
    返回数组能分成的最多块数量.
 */
public class maxChunksToSorted_769 {
    //当遍历到第i个位置时, 如果可以切分为块, 那前i个位置的最大值一定等于i;
    //否则, 一定有比i小的数划分到后面的块, 那块排序后, 一定不满足升序.
    public int maxChunksToSorted(int[] arr) {
        int res = 0;
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(arr[i], max);
            if(max == i){
                res++;
            }
        }
        return res;
    }

    //模拟
    //i为右边界, j为左边界
    public int maxChunksToSorted2(int[] arr) {
        int res = 0, n = arr.length;
        int max = -1, min = n;
        for(int i = 0, j = 0; i < arr.length; i++){
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);
            if(max == i && min == j){
                res++;
                j = i + 1;
                min = n;
                max = -1;
            }
        }
        return res;
    }
}
