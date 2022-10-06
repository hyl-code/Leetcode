package October_2022;

/*
    给你一个数组, 将数组中的元素向右轮转 k 个位置, 其中 k 是非负数 .
 */
public class rotate_189 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] temp = new int[n];
        for(int i = 0; i < n; i++){
            temp[i] = nums[i];
        }
        for(int i = 0; i < n; i++){
            k %= n;
            nums[i] = temp[(n + i - k) % n];
        }
    }

    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        int[] temp = new int[n];
        for(int i = 0; i < n; i++){
            temp[i] = nums[i];
        }
        for(int i = 0; i < n; i++){
            nums[(i + k) % n] = temp[i];
        }
    }

    //数组翻转
    public void rotate3(int[] nums, int k) {
        k %= nums.length;
        //翻转所有元素
        reverse(nums, 0, nums.length - 1);
        //翻转 [0,(k mod n)−1] 区间的元素
        reverse(nums, 0, k - 1);
        //翻转 [k mod n,n−1] 区间的元素
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
