package April_2021;

    //80.给你一个有序数组nums，请你原地删除重复出现的元素，使每个元素最多出现两次，返回删除后数组的新长度。
       //不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

public class Delete_duplicatesII_80 {
    public int removeDuplicates(int[] nums) {
        int i = 0;

        for(int n : nums){
            if(i < 2 || n > nums[i - 2])
                nums[i++] = n;
        }//使用for each循环，直接迭代数组的每个元素

        return i;
    }
}
