package August_2023;

import java.util.ArrayList;
import java.util.List;
/*
    给你一个无重叠的, 按照区间起始端点排序的区间列表.
    在列表中插入一个新的区间, 你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）.
 */
public class insert_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> resList = new ArrayList<int[]>();
        for(int[] interval : intervals){
            if(interval[0] > right){        // 在插入区间左侧
                if(!placed){
                    resList.add(new int[]{left, right});
                    placed = true;
                }
                resList.add(interval);
            }else if(interval[1] < left){   //在插入区间右侧
                resList.add(interval);
            }else{
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if(!placed){
            resList.add(new int[]{left, right});
        }
        int[][] res = new int[resList.size()][2];
        for(int i = 0; i < resList.size(); i++){
            res[i] = resList.get(i);
        }
        return res;
    }
}
