package September_2021;

/*
    给定两个大小分别为 m 和 n 的正序(从小到大)数组 nums1 和 nums2.
    请你找出并返回这两个正序数组的 中位数 .
 */

public class findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = 0, n = 0;
        int i = 0, len = nums1.length + nums2.length;
        int[] num = new int[len];
        double res;

        if(len <= 1){
            if(nums1.length == 1)
                return nums1[0];
            else
                return nums2[0];
        }

        while(m <= nums1.length - 1 && n <= nums2.length - 1){
            if(nums1[m] > nums2[n]){
                num[i++] = nums2[n++];
            }else{
                num[i++] = nums1[m++];
            }
        }

        while(m <= nums1.length - 1)
            num[i++] = nums1[m++];
        while(n <= nums2.length - 1)
            num[i++] = nums2[n++];

        if(len % 2 == 1){
            return num[len / 2];
        }else{
            return (double)(num[len / 2 - 1] + num[len / 2]) / 2;
        }
    }
}
