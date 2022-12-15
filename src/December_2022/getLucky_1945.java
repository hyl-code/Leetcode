package December_2022;

/*
    给你一个由小写字母组成的字符串 s, 以及一个整数 k.
    首先, 用字母在字母表中的位置替换该字母, 将 s 转化为一个整数
    (也就是, 'a' 用 1 替换, 'b' 用 2 替换, ... 'z' 用 26 替换).
    接着, 将整数转换为其各位数字之和. 共重复转换操作 k 次.
    例如, 如果 s = "zbax" 且 k = 2, 那么执行下述步骤后得到的结果是整数 8;
    转化: "zbax" ➝ "(26)(2)(1)(24)" ➝ "262124" ➝ 262124
    转换 #1: 262124 ➝ 2 + 6 + 2 + 1 + 2 + 4 ➝ 17
    转换 #2: 17 ➝ 1 + 7 ➝ 8
    返回执行上述操作后得到的结果整数.
 */
public class getLucky_1945 {
    public int getLucky(String s, int k) {
        int n = s.length();
        int res = 0;
        for(int i = 0; i < n; i++){
            int num = s.charAt(i) - 'a' + 1;
            while(num > 0){
                res += (num % 10);
                num /= 10;
            }
        }
        k--;
        while(k > 0){
            int temp = res;
            res = 0;
            while(temp > 0){
                res += (temp % 10);
                temp /= 10;
            }
            k--;
        }
        return res;
    }
}
