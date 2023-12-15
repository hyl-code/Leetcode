package December_2023;

import java.util.Map;
import java.util.TreeMap;
/*
    给你区间的空集, 请你设计并实现满足要求的数据结构：
        新增：添加一个区间到这个区间集合中.
        统计：计算出现在至少一个区间中的整数个数.
    实现 CountIntervals 类：
        CountIntervals() 使用区间的空集初始化对象
        void add(int left, int right) 添加区间 [left, right] 到区间集合之中.
        int count() 返回出现在 至少一个 区间中的整数个数.
    注意：区间 [left, right] 表示满足 left <= x <= right 的所有整数 x.
 */
public class CountIntervals_2276 {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    int cnt = 0;

    public CountIntervals_2276() {

    }

    public void add(int left, int right) {
        Map.Entry<Integer, Integer> interval = map.floorEntry(right);
        while(interval != null && interval.getValue() >= left){
            int l = interval.getKey(), r = interval.getValue();
            left = Math.min(left, l);
            right = Math.max(right, r);
            cnt -= r - l + 1;
            map.remove(l);
            interval = map.floorEntry(right);
        }
        cnt += (right - left + 1);
        map.put(left, right);
    }

    public int count() {
        return cnt;
    }
}
