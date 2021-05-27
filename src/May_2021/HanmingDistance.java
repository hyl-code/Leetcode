package May_2021;

//两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
//
//给出两个整数 x 和 y,计算它们之间的汉明距离.

public class HanmingDistance {
    public int hammingDistance(int x, int y) {
        int a = x ^ y;
        int b = 0;

        while(a != 0){
            if(a % 2 == 1){
                b++;
            }
            a /= 2;
        }
        return b;
    } //异或
}
