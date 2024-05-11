package May_2024;

import java.util.HashMap;
import java.util.Map;

/*
    给你一个下标从 0 开始的字符串数组 garbage，其中 garbage[i] 表示第 i 个房子的垃圾集合.
    garbage[i] 只包含字符 'M' ，'P' 和 'G' ，但可能包含多个相同字符，每个字符分别表示一单位的金属、纸和玻璃.
    垃圾车收拾一单位的任何一种垃圾都需要花费 1 分钟.
    同时给你一个下标从 0 开始的整数数组 travel，其中 travel[i] 是垃圾车从房子 i 行驶到房子 i + 1 需要的分钟数.
    城市里总共有三辆垃圾车，分别收拾三种垃圾. 每辆垃圾车都从房子 0 出发，按顺序到达每一栋房子. 但它们不是必须到达所有的房子.
    任何时刻只有一辆垃圾车处在使用状态. 当一辆垃圾车在行驶或者收拾垃圾的时候，另外两辆车不能做任何事情.
    请你返回收拾完所有垃圾需要花费的最少总分钟数.
 */
public class garbageCollection_2391 {
    public int garbageCollection(String[] garbage, int[] travel) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0, curDis = 0;
        for (int i = 0; i < garbage.length; i++) {
            res += garbage[i].length();
            if (i > 0) {
                curDis += travel[i - 1];
            }
            for (char c : garbage[i].toCharArray()) {
                map.put(c, curDis);
            }
        }
        for(int dis : map.values()) {
            res += dis;
        }
        return res;
    }
}
