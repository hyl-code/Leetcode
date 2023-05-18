package May_2023;

import java.util.ArrayList;
import java.util.List;

/*
    给出基数为 -2 的两个数 arr1 和 arr2, 返回两数相加的结果.
    数字以数组形式给出: 数组由若干 0 和 1 组成, 按最高有效位到最低有效位的顺序排列.
    例如, arr = [1,1,0,1] 表示数字 (-2)^3 + (-2)^2 + (-2)^0 = -3.
    数组形式中的数字 arr 也同样不含前导零: 即 arr == [0] 或 arr[0] == 1.
    返回相同表示形式的 arr1 和 arr2 相加的结果.
    两数的表示形式为: 不含前导零、由若干 0 和 1 组成的数组.
 */
public class addNegabinary_1073 {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int i = arr1.length - 1, j = arr2.length - 1;
        List<Integer> list = new ArrayList<>();
        int tag = 0;
        while (i >= 0 || j >= 0 || tag != 0) {
            int x = tag;
            if (i >= 0) {
                x += arr1[i];
            }
            if (j >= 0) {
                x += arr2[j];
            }
            if (x >= 2) {
                list.add(x - 2);
                tag = -1;
            } else if (x >= 0) {
                list.add(x);
                tag = 0;
            } else {                //当 x = -1 时, -(-2)^i = (-2)^(i+1) + (-2)^i
                list.add(1);
                tag = 1;
            }
            i--;
            j--;
        }
        while (list.size() > 1 && list.get(list.size() - 1) == 0) {
            list.remove(list.size() - 1);
        }
        int[] res = new int[list.size()];
        for (i = 0, j = list.size() - 1; j >= 0; i++, j--) {
            res[i] = list.get(j);
        }
        return res;
    }
}
