package October_2022;

/*
    颠倒给定的 32 位无符号整数的二进制位.
 */
public class reverseBits_190 {
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32 && n != 0; i++){
            //从低位到高位枚举每一位, 将其倒序与 res 相加
            res |= (n & 1) << (31- i);
            //每枚举一位, n 向右移动一位, 直至 n == 0.
            n >>>= 1;
        }
        return res;
    }
}
