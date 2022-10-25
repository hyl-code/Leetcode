package October_2022;

import java.util.List;

/*
    给定一个三角形 triangle, 找出自顶向下的最小路径和.
    每一步只能移动到下一行中相邻的结点上.
    相邻的结点在这里指的是下标与上一层结点下标相同或者等于上一层结点下标 + 1 的两个结点.
    也就是说, 如果正位于当前行的下标 i, 那么下一步可以移动到下一行的下标 i 或 i + 1.
 */
public class minimumTotal_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0 || triangle == null){
            return 0;
        }
        // + 1 不用初始化
        int[] nums = new int[triangle.size() + 1];
        //从下往上 +
        for(int i = triangle.size() - 1; i >= 0; i--){
            List<Integer> list = triangle.get(i);
            for(int j = 0; j < list.size(); j++){
                //这里的 dp[j] 使用的时候默认是上一层的, 赋值之后变成当前层.
                nums[j] = Math.min(nums[j], nums[j + 1]) + list.get(j);
            }
        }
        return nums[0];
    }
}
