package October_2022;

/*
    我们构建了一个包含 n 行(索引从  1 开始)的表.
    首先在第一行我们写上一个 0.
    接下来的每一行, 将前一行中的 0 替换为 01, 1 替换为 10.
    例如, 对于 n = 3, 第 1 行是 0, 第 2 行是 01, 第 3 行是 0110.
    给定行数 n 和序数 k, 返回第 n 行中第 k 个字符.( k 从索引 1 开始)
 */
public class kthGrammar_779 {
    //作 n 行满二叉树,
    public int kthGrammar(int n, int k) {
        if(n == 1){
            return 0;
        }
        int num = k % 2;
        //引理: 0 异或一个数 == 该数的值; 1异或一个数 == 该数值取反
        //左孩子与父亲相同, 否则相反
        //判断 k 是否为偶数:
        //如果是偶数, 就是右孩子; 如果是奇数, 则是左孩子
        return num == 0 ? 1 ^ kthGrammar(n - 1, (k + 1) / 2) : 0 ^ kthGrammar(n - 1, (k + 1) / 2);
    }
}
