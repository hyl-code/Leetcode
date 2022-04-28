package April_2022;

/*
    给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums, 原地对它们进行排序,
    使得相同颜色的元素相邻, 并按照红色、白色、蓝色顺序排列.
    我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色 .
    必须在不使用库的 sort 函数的情况下解决这个问题 .
 */

public class sortColors_75 {
    //冒泡排序
    public void sortColors(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = 0; j < nums.length - i - 1; j++){
                if(nums[j] > nums[j + 1]){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}
