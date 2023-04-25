package April_2023;

import java.util.*;

/*
    给你一个字符串数组 names, 和一个由互不相同的正整数组成的数组heights. 两个数组的长度均为 n.
    对于每个下标 i, names[i] 和 heights[i] 表示第 i 个人的名字和身高.
    请按身高降序顺序返回对应的名字数组 names.
 */
public class sortPeople_2418 {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>();
        int n = names.length;
        String[] res = new String[n];
        for(int i = 0; i < n; i++){
            map.put(heights[i], names[i]);
        }
        Arrays.sort(heights);
        for(int i = 0; i < n; i++){
            res[i] = map.get(heights[n - i - 1]);
        }
        return res;
    }

    //利用 TreeMap 得到结果, TreeMap 是根据 key 按顺序遍历的
    public String[] sortPeople2(String[] names, int[] heights) {
        Map<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());
        for(int i = 0; i < names.length; i++){
            map.put(heights[i], names[i]);
        }
        return map.values().toArray(new String[names.length]);
    }
}
