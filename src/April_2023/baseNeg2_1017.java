package April_2023;

/*
    给你一个整数 n, 以二进制字符串的形式返回该整数的负二进制 (base -2) 表示.
    注意, 除非字符串就是 "0", 否则返回的字符串中不能含有前导零.
 */
public class baseNeg2_1017 {
    public String baseNeg2(int n) {
        if(n == 0){
            return "0";
        }
        int k = 1;
        StringBuilder sb = new StringBuilder();
        while(n != 0){
            if(n % 2 != 0){
                sb.append(1);
                n -= k;
            }else{
                sb.append(0);
            }
            k *= -1;
            n /= 2;
        }
        return sb.reverse().toString();
    }
}
