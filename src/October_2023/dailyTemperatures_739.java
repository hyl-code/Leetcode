package October_2023;

import java.util.Stack;
/*
    给定一个整数数组 temperatures, 表示每天的温度, 返回一个数组 answer, 其中 answer[i] 是指对于第 i 天, 下一个更高温度出现在几天后.
    如果气温在这之后都不会升高, 请在该位置用 0 来代替.
 */
public class dailyTemperatures_739 {
    // 单调栈
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] res = new int[n];
        stack.push(0);
        for(int i = 1; i < n; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int pre = stack.pop();
                res[pre] = i - pre;
            }
            stack.push(i);
        }
        return res;
    }
}
