package November_2021;

import java.util.Deque;
import java.util.LinkedList;

/*
    给定 n 个非负整数表示每个宽度为 1 的柱子的高度图,
    计算按此排列的柱子, 下雨之后能接多少雨水 .
 */

public class trap_42 {
    //动态规划
    public int trap1(int[] height) {
        if(height == null && height.length == 0)
            return 0;

        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int res = 0;

        left[0] = height[0];
        for(int i = 1; i < height.length; i++){
            left[i] = Math.max(height[i], left[i-1]);
        }
        right[height.length - 1] = height[height.length - 1];
        for(int i = height.length - 2; i >= 0; i--){
            right[i] = Math.max(right[i+1], height[i]);
        }
        for(int i = 0; i < height.length; i++){
            res += Math.min(left[i], right[i]) - height[i];
        }
        return res;
    }

    //栈
    public int trap2(int[] height) {
        int res = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        for(int i = 0; i < height.length; i++){
            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                int top = stack.pop();
                if(stack.isEmpty())
                    break;
                int left = stack.peek();
                int width = i - left - 1;
                int h = Math.min(height[left], height[i]) - height[top];
                res += width * h;
            }
            stack.push(i);
        }
        return res;
    }

    //双指针
    public int trap3(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while(left < right){
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);
            if(height[left] < height[right]){
                res += leftMax - height[left];
                left++;
            }else{
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
