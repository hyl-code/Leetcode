package May_2023;

import java.util.Stack;

/*
    给你一个正整数数组 arr, 考虑所有满足以下条件的二叉树：
        每个节点都有 0 个或是 2 个子节点.
        数组 arr 中的值与树的中序遍历中每个叶节点的值一一对应.
        每个非叶节点的值等于其左子树和右子树中叶节点的最大值的乘积.
    在所有这样的二叉树中, 返回每个非叶节点的值的最小可能总和. 这个和的值是一个 32 位整数.
    如果一个节点有 0 个子节点, 那么该节点为叶节点.
 */
public class mctFromLeafValues_1130 {
    //单调栈
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);      //设置哨兵
        int res = 0;
        for(int i = 0; i < arr.length; i++){
            while(stack.peek() < arr[i]){   //若栈顶元素比当前元素小, 弹出栈顶元素
                res += stack.pop() * Math.min(stack.peek(), arr[i]);//取相邻两个数的最小数
            }
            stack.push(arr[i]);             //若栈顶元素比当前元素大，则入栈
        }
        while(stack.size() > 2){
            res += stack.pop() * stack.peek();
        }
        return res;
    }
}
