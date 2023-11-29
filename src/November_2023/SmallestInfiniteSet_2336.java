package November_2023;

import java.util.TreeSet;
/*
    现有一个包含所有正整数的集合 [1, 2, 3, 4, 5, ...].
    实现 SmallestInfiniteSet 类：
        SmallestInfiniteSet() 初始化 SmallestInfiniteSet 对象以包含所有正整数.
        int popSmallest() 移除并返回该无限集中的最小整数.
        void addBack(int num) 如果正整数 num 不 存在于无限集中, 则将一个 num 添加到该无限集中.
 */
public class SmallestInfiniteSet_2336 {
    private int begin;
    private TreeSet<Integer> set;

    public SmallestInfiniteSet_2336() {
        begin = 1;
        set = new TreeSet<Integer>();
    }

    public int popSmallest() {
        int res = 0;
        if(set.isEmpty()){
            res = begin;
            begin++;
        }else{
            res = set.pollFirst();
        }
        return res;
    }

    public void addBack(int num) {
        if(num < begin){
            set.add(num);
        }
    }
}
