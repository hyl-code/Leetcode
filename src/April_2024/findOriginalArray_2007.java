package April_2024;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*
    一个整数数组 original 可以转变成一个双倍数组 changed，转变方式为将 original 中每个元素值乘以 2 加入数组中，然后将所有元素随机打乱.
    给你一个数组 changed，如果 change 是双倍数组，那么请你返回 original 数组，否则请返回空数组.
    original 的元素可以以任意顺序返回.
 */
public class findOriginalArray_2007 {
    public int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : changed) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[changed.length / 2];
        int i = 0;
        for (int num : changed) {
            if (cnt.get(num) == 0) {
                continue;
            }
            cnt.put(num, cnt.get(num) - 1);
            if (cnt.getOrDefault(num * 2, 0) == 0) {
                return new int[0];
            }
            cnt.put(num * 2, cnt.get(num * 2) - 1);
            res[i++] = num;
        }
        return res;
    }
}
