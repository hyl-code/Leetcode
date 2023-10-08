package October_2023;

import java.util.HashMap;
import java.util.TreeMap;
/*
    给你一支股票价格的数据流. 数据流中每一条记录包含一个时间戳和该时间点股票对应的价格.
    不巧的是, 由于股票市场内在的波动性, 股票价格记录可能不是按时间顺序到来的.
    某些情况下, 有的记录可能是错的. 如果两个有相同时间戳的记录出现在数据流中, 前一条记录视为错误记录, 后出现的记录更正前一条错误的记录.
    请你设计一个算法, 实现：
        更新股票在某一时间戳的股票价格, 如果有之前同一时间戳的价格, 这一操作将更正之前的错误价格.
        找到当前记录里 最新股票价格. 最新股票价格定义为时间戳最晚的股票价格.
        找到当前记录里股票的最高价格.
        找到当前记录里股票的最低价格.
    请你实现 StockPrice 类：
        StockPrice() 初始化对象, 当前无股票价格记录.
        void update(int timestamp, int price) 在时间点 timestamp 更新股票价格为 price.
        int current() 返回股票最新价格.
        int maximum() 返回股票最高价格.
        int minimum() 返回股票最低价格.
 */
public class StockPrice_2034 {
    int maxTimestamp;
    HashMap<Integer, Integer> timePriceMap;
    TreeMap<Integer, Integer> prices;

    public StockPrice_2034() {
        maxTimestamp = 0;
        timePriceMap = new HashMap<>();
        prices = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        maxTimestamp = Math.max(maxTimestamp, timestamp);
        int prePrice = timePriceMap.getOrDefault(timestamp, 0);
        timePriceMap.put(timestamp, price);
        if(prePrice > 0){
            prices.put(prePrice, prices.get(prePrice) - 1);
            if(prices.get(prePrice) == 0){
                prices.remove(prePrice);
            }
        }
        prices.put(price, prices.getOrDefault(price, 0) + 1);
    }

    public int current() {
        return timePriceMap.get(maxTimestamp);
    }

    public int maximum() {
        return prices.lastKey();
    }

    public int minimum() {
        return prices.firstKey();
    }
}
