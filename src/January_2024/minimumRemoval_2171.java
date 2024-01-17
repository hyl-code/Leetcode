package January_2024;

import java.util.Arrays;
/*
    给定一个正整数数组 beans, 其中每个整数表示一个袋子里装的魔法豆的数目.
    请你从每个袋子中拿出一些豆子（也可以不拿出）, 使得剩下的非空袋子中（即至少还有一颗魔法豆的袋子）魔法豆的数目相等.
    一旦把魔法豆从袋子中取出, 你不能再将它放到任何袋子中.
    请返回你需要拿出魔法豆的最少数目.
 */
public class minimumRemoval_2171 {
    public long minimumRemoval(int[] beans) {
        int n = beans.length;
        Arrays.sort(beans);
        long total = 0;
        for(int i = 0; i < n; i++){
            total += beans[i];
        }
        long res = total;
        for(int i = 0; i < n; i++){
            res = Math.min(res, total - (long) beans[i] * (n - i));
        }
        return res;
    }
}
