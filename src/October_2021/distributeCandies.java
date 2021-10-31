package October_2021;

import java.util.HashSet;

/*
    给定一个偶数长度的数组, 其中不同的数字代表着不同种类的糖果, 每一个数字代表一个糖果.
    你需要把这些糖果平均分给一个弟弟和一个妹妹. 返回妹妹可以获得的最大糖果的种类数.
 */

public class distributeCandies {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> set = new HashSet<>();
        int n = candyType.length / 2;
        for(int num : candyType){
            set.add(num);
        }
        return n > set.size() ? set.size() : n;
    }
}
