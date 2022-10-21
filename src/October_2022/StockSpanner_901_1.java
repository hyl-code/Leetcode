package October_2022;

import java.util.ArrayList;
import java.util.List;

/*
    编写一个 StockSpanner 类, 它收集某些股票的每日报价, 并返回该股票当日价格的跨度.
    今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数(从今天开始往回数, 包括今天).
    例如, 如果未来 7天股票的价格是 [100, 80, 60, 70, 60, 75, 85], 那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6].
 */
public class StockSpanner_901_1 {
    //暴力法
    List<Integer> list;
    public StockSpanner_901_1() {
        list = new ArrayList<>();
    }

    public int next(int price) {
        list.add(price);
        for(int i = list.size() - 1; i >= 0; i--){
            if(list.get(i) > price){
                return list.size() - i - 1;
            }
        }
        return list.size();
    }
}

