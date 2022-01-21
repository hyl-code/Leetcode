package January_2022;

public class firstMissingPositive_41 {
    public int firstMissingPositive1(int[] nums) {
        if(nums.length == 0)
            return 1;
        //新建辅助数组
        int[] res = new int[nums.length + 1];
        //将数组元素添加到辅助数组中
        for(int i : nums){
            if(i > 0 && i < res.length){
                res[i] = i;
            }
        }
        //遍历查找
        for(int i = 1; i < res.length; i++){
            if(res[i] != i){
                return i;
            }
        }
        //缺少最后一个
        return res.length;
    }

    public int firstMissingPositive2(int[] nums){
        int n = nums.length;
        if(n == 0)
            return 1;
        for(int i = 0; i < n; i++){
            while(nums[i] > 0 && nums[i] < n + 1 && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }
        }
        //遍历寻找缺少的正数
        for(int i = 0; i < n; i++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return n + 1;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
