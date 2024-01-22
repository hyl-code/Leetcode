package January_2024;

/*
    给定一个非负整数, 你至多可以交换一次数字中的任意两位. 返回你能得到的最大值.
 */
public class maximumSwap_670 {
    public int maximumSwap(int num) {
        char[] cs = String.valueOf(num).toCharArray();
        int n = cs.length;
        int maxNum = num;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                swap(cs, i, j);
                maxNum = Math.max(maxNum, Integer.parseInt(new String(cs)));
                swap(cs, i, j);
            }
        }
        return maxNum;
    }

    public void swap(char[] cs, int i, int j){
        char tmp = cs[i];
        cs[i] = cs[j];
        cs[j] = tmp;
    }
}
