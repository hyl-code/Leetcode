package September_2022;

/*
    你有一个炸弹需要拆除, 时间紧迫! 你的情报员会给你一个长度为 n 的循环数组 code 以及一个密钥 k .
    为了获得正确的密码, 你需要替换掉每一个数字. 所有数字会同时被替换 .
    如果 k > 0 , 将第 i 个数字用接下来 k 个数字之和替换.
    如果 k < 0 ,将第 i 个数字用之前 k 个数字之和替换.
    如果 k == 0 ,将第 i 个数字用 0 替换.
    由于 code 是循环的, code[n-1] 下一个元素是 code[0] , 且 code[0] 前一个元素是 code[n-1] .
    给你循环数组 code 和整数密钥 k, 请你返回解密后的结果来拆除炸弹!
 */
public class decrypt_1652 {
    //分情况讨论
    public int[] decrypt(int[] code, int k) {
        int len = code.length;
        int[] res = new int[len];
        for(int i = 0; i < len; i++){
            int num = 0;
            if(k > 0){
                for(int j = 1; j <= k; j++){
                    num += code[(i + j + len) % len];
                }
            }else if(k < 0){
                for(int j = k; j < 0; j++){
                    num += code[(i + j + len) % len];
                }
            }
            res[i] = num;
        }
        return res;
    }

    // e为标识符 省略分情况讨论
    public int[] decrypt2(int[] code, int k) {
        int len = code.length;
        int[] res = new int[len];
        int e = k >= 0 ? (k == 0 ? 0 : 1) : -1;
        for(int i = 0; i < len; i++){
            int num = 0;
            for(int j = e; j != k + e; j += e){
                num += code[(i + j + len) % len];
            }
            res[i] = num;
        }
        return res;
    }
}
