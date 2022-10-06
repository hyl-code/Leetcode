package October_2022;

public class moveZeroes_283 {
    //最笨的方法
    public void moveZeroes(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length - 1; j++){
                if(nums[j] == 0 && nums[j + 1] != 0){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    //双指针
    //二次遍历
    public void moveZeroes2(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[j++] = nums[i];
            }
        }
        for(int i = j; i < nums.length; i++){
            nums[i] = 0;
        }
    }

    //一次遍历 非 0 交换
    public void moveZeroes3(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }
}
