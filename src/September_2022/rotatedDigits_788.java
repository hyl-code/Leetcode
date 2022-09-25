package September_2022;

/*
    我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后, 我们仍可以得到一个有效的, 且和 X 不同的数 .
    要求每位数字都要被旋转 .
    如果一个数的每位数字被旋转以后仍然还是一个数字, 则这个数是有效的 .
    0, 1, 和 8 被旋转后仍然是它们自己; 2 和 5 可以互相旋转成对方
    (在这种情况下, 它们以不同的方向旋转, 换句话说，2 和 5 互为镜像);
    6 和 9 同理, 除了这些以外其他的数字旋转以后都不再是有效的数字 .
    现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数 ?
 */
public class rotatedDigits_788 {
    public int rotatedDigits(int n) {
        int res = 0;
        for(int i = 1; i <= n; i++){
            int val = i;
            int count = 0;
            while(val > 0){
                int temp = val % 10;
                if(temp == 2 || temp == 5 || temp == 6 || temp == 9){
                    count = 1;
                }else if(temp == 3 || temp == 4 || temp == 7){
                    count = 0;
                    break;
                }
                val /= 10;
            }
            res += count;
        }
        return res;
    }
}
