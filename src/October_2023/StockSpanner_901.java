package October_2023;

import java.util.ArrayList;
import java.util.List;
/*
    设计一个算法收集某些股票的每日报价, 并返回该股票当日价格的跨度.
    当日股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数, 包括今天）.
    例如, 如果未来 7 天股票的价格是 [100,80,60,70,60,75,85], 那么股票跨度将是 [1,1,1,2,1,4,6] .
    实现 StockSpanner 类：
        StockSpanner() 初始化类对象.
        int next(int price) 给出今天的股价 price, 返回该股票当日价格的跨度.
 */
public class StockSpanner_901 {
    List<int[]> list;

    public StockSpanner_901() {
        list = new ArrayList<>();
    }

    public int next(int price) {
        int i = list.size() - 1, res = 1;
        int[] item;
        while(i >= 0){
            item = list.get(i);
            if(item[0] <= price){
                i -= item[1];
                res += item[1];
            }else{
                break;
            }
        }
        list.add(new int[]{ price, res });
        return res;
    }
}
