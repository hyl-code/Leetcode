package October_2022;

import java.util.ArrayList;
import java.util.List;

/*
    编写一个 StockSpanner 类, 它收集某些股票的每日报价, 并返回该股票当日价格的跨度.
    今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数(从今天开始往回数, 包括今天).
    例如, 如果未来 7天股票的价格是 [100, 80, 60, 70, 60, 75, 85], 那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6].
 */
public class StockSpanner_901_2 {
    List<int[]> list;
    public StockSpanner_901_2() {
        list = new ArrayList<>();
    }
    //数组存储前一天的价格和前一天的价格跨度
    public int next(int price) {
        int i = list.size() - 1, res = 1;
        int[] item;
        //从前往后遍历
        while(i >= 0){
            item = list.get(i);
            if(item[0] <= price){
                i -= item[1];
                res += item[1];
            }else{
                break;
            }
        }
        list.add(new int[]{price, res});
        return res;
    }
}
