package December_2023;

/*
    如果整数 x 满足：对于每个数位 d, 这个数位恰好在 x 中出现 d 次. 那么整数 x 就是一个数值平衡数.
    给你一个整数 n, 请你返回严格大于 n 的 最小数值平衡数.
 */
public class nextBeautifulNumber_2048 {
    public int nextBeautifulNumber(int n) {
        for(int i = n + 1; i <= 1224444; i++){
            if(isBalance(i)){
                return i;
            }
        }
        return -1;
    }

    private boolean isBalance(int x){
        int[] cnt = new int[10];
        while(x > 0){
            cnt[x % 10]++;
            x /= 10;
        }
        for(int i = 0; i < 10; i++){
            if(cnt[i] > 0 && cnt[i] != i){
                return false;
            }
        }
        return true;
    }
}
