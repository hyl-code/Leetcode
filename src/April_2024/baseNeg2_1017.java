package April_2024;

/*
    给你一个整数 n ，以二进制字符串的形式返回该整数的负二进制（base -2）表示.
    注意，除非字符串就是 "0"，否则返回的字符串中不能含有前导零.
 */
public class baseNeg2_1017 {
    public String baseNeg2(int n) {
        if (n == 0) {
            return "0";
        }
        int[] bits = new int[32];
        for (int i = 0; i < 32 && n != 0; i++) {
            if ((n & 1) != 0) {
                bits[i]++;
                if ((i & 1) != 0) {
                    bits[i + 1]++;
                }
            }
            n >>= 1;
        }
        int carry = 0;
        for (int i = 0; i < 32; i++) {
            int val = carry + bits[i];
            bits[i] = val & 1;
            carry = (val - bits[i]) / (-2);
        }
        int pos = 31;
        StringBuilder sb = new StringBuilder();
        while (pos >= 0 && bits[pos] == 0) {
            pos--;
        }
        while (pos >= 0) {
            sb.append(bits[pos]);
            pos--;
        }
        return sb.toString();
    }
}
