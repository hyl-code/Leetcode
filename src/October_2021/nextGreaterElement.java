package October_2021;

/*
    给你两个没有重复元素的数组 nums1 和 nums2, 其中 nums1 是 nums2 的子集 .
    请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值 .
    nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素 .
    如果不存在, 对应位置输出 -1 .
 */

public class nextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            int j = 0;
            while(j < nums2.length && nums1[i] != nums2[j]){
                j++;
            }
            int k = j + 1;
            while(k < nums2.length && nums2[j] > nums2[k]){
                k++;
            }
            res[i] = k < nums2.length ? nums2[k] : -1;
        }
        return res;
    }
}
