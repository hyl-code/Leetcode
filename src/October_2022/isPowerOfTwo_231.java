package October_2022;

/*
    给你一个整数 n, 请你判断该整数是否是 2 的幂次方.
    如果是, 返回 true; 否则, 返回 false.
    如果存在一个整数 x 使得 n == 2x, 则认为 n 是 2 的幂次方.
 */
public class isPowerOfTwo_231 {
    public boolean isPowerOfTwo(int n) {
        //位运算:
        //  2的幂: 1、10、100...      2的幂 - 1: 0、01、011...
        return n > 0 && (n & (n - 1)) == 0;
    }
}
