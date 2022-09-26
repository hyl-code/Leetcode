package September_2022;

/*
    给定一个数组, 包含从 1 到 N 所有的整数, 但其中缺了两个数字 .
    你能在 O(N) 时间内只用 O(1) 的空间找到它们吗 ?
    以任意顺序返回这两个数字均可 .
 */
public class missingTwo_17_19 {
    //数学方法
    public int[] missingTwo(int[] nums) {
        //加上缺失数字后总长度
        int n = nums.length + 2;
        //求和公式: n * (n + 1) / 2
        int cur = n * (1 + n) / 2;
        for(int num : nums){
            cur -= num;
        }
        //第一个缺失数取值范围为 0 < t < cur / 2
        int sum = cur, t = cur / 2;
        cur = t * (t + 1) / 2;
        for(int num : nums){
            if(num <= t){
                cur -= num;
            }
        }
        return new int[]{cur, sum - cur};
    }
}
