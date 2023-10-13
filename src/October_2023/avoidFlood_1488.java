package October_2023;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
/*
    你的国家有无数个湖泊, 所有湖泊一开始都是空的. 当第 n 个湖泊下雨前是空的, 那么它就会装满水.
    如果第 n 个湖泊下雨前是满的, 这个湖泊会发生洪水. 你的目标是避免任意一个湖泊发生洪水.
    给你一个整数数组 rains, 其中：
        rains[i] > 0 表示第 i 天时, 第 rains[i] 个湖泊会下雨.
        rains[i] == 0 表示第 i 天没有湖泊会下雨, 你可以选择一个湖泊并抽干这个湖泊的水.
    请返回一个数组 ans, 满足：
        ans.length == rains.length
        如果 rains[i] > 0, 那么ans[i] == -1.
        如果 rains[i] == 0, ans[i] 是你第 i 天选择抽干的湖泊.
    如果有多种可行解, 请返回它们中的任意一个. 如果没办法阻止洪水, 请返回一个空的数组.
    请注意, 如果你选择抽干一个装满水的湖泊, 它会变成一个空的湖泊. 但如果你选择抽干一个空的湖泊, 那么将无事发生.
 */
public class avoidFlood_1488 {
    // 贪心
    public int[] avoidFlood(int[] rains) {
        int[] res = new int[rains.length];
        Arrays.fill(res, 1);
        TreeSet<Integer> st = new TreeSet<Integer>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < rains.length; i++){
            if(rains[i] == 0){
                st.add(i);
            }
            else{
                res[i] = -1;
                if(map.containsKey(rains[i])){
                    Integer it = st.ceiling(map.get(rains[i]));
                    if(it == null){
                        return new int[0];
                    }
                    res[it] = rains[i];
                    st.remove(it);
                }
                map.put(rains[i], i);
            }
        }
        return res;
    }
}
