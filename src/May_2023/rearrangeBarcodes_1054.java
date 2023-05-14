package May_2023;

import java.util.HashMap;
import java.util.Map;

/*
    在一个仓库里, 有一排条形码, 其中第 i 个条形码为 barcodes[i].
    请你重新排列这些条形码, 使其中任意两个相邻的条形码不能相等.
    你可以返回任何满足该要求的答案, 此题保证存在答案.
 */
public class rearrangeBarcodes_1054 {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int len = barcodes.length;
        if(len < 2){
            return barcodes;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int code : barcodes){
            map.put(code, map.getOrDefault(code, 0) + 1);
        }
        // oddIndex 代表奇数下标, evenIndex 代表偶数下标
        int evenIndex = 0;
        int oddIndex = 1;
        int[] res = new int[len];
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int code = entry.getKey();
            int count = entry.getValue();
            //如果元素出现次数 count > 0 && count <= len / 2, 同时 oddIndex 没有超出数组下标范围, 将元素放置在 oddIndex
            while(count > 0 && count <= len / 2 && oddIndex < len){
                res[oddIndex] = code;
                count--;
                oddIndex += 2;
            }
            //如果元素出现次数 count > 0 && count > len / 2, 将元素放置在 evenIndex.
            while(count > 0){
                res[evenIndex] = code;
                count--;
                evenIndex += 2;
            }
        }
        return res;
    }
}
