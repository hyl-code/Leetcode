package May_2024;

import java.util.Arrays;

/*
    给你一个整数数组 salary，数组里每个数都是唯一的，其中 salary[i] 是第 i 个员工的工资.
    请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值.
 */
public class average_1491 {
    public double average(int[] salary) {
        Arrays.sort(salary);
        int sum = 0;
        for(int i = 1; i < salary.length - 1; i++) {
            sum += salary[i];
        }
        return (double) sum / (salary.length - 2);
    }
}
