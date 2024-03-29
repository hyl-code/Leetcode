package October_2022;

/*
    编写一个函数, 输入是一个无符号整数(以二进制串的形式),
    返回其二进制表达式中数字位数为 '1' 的个数(也被称为汉明重量).
 */
public class hammingWeight_191 {
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0){
            //从右往左, 依次将 1 变为 0
            n = n & (n - 1);
            res++;
        }
        return res;
    }
}
