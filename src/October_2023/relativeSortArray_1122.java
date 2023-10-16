package October_2023;

/*
    给你两个数组 arr1 和 arr2, arr2 中的元素各不相同, arr2 中的每个元素都出现在 arr1 中.
    对 arr1 中的元素进行排序, 使 arr1 中项的相对顺序和 arr2 中的相对顺序相同.
    未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾.
 */
public class relativeSortArray_1122 {
    // 计数
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int upper = 0;
        for(int num : arr1){
            upper = Math.max(upper, num);
        }
        int[] cnt = new int[upper + 1];
        for(int num : arr1){
            cnt[num]++;
        }
        int[] res = new int[arr1.length];
        int idx = 0;
        for(int num : arr2){
            for(int i = 0; i < cnt[num]; i++){
                res[idx++] = num;
            }
            cnt[num] = 0;
        }
        for(int num = 0; num <= upper; num++){
            for(int i = 0; i < cnt[num]; i++){
                res[idx++] = num;
            }
        }
        return res;
    }
}
