package May_2023;

/*
    给你一个长度为 5 的字符串 time, 表示一个电子时钟当前的时间, 格式为 "hh:mm".
    最早可能的时间是 "00:00", 最晚可能的时间是 "23:59".
    在字符串 time 中, 被字符 '?' 替换掉的数位是未知的, 被替换的数字可能是 0 到 9 中的任何一个.
    请你返回一个整数 answer, 将每一个 '?' 都用 0 到 9 中一个数字替换后, 可以得到的有效时间的数目.
 */
public class countTime_2437 {
    public int countTime(String time) {
        int[] nums = {2, 10, 1, 6, 10};
        char[] str = time.toCharArray();
        int res = 1;
        for(int i = 0; i < str.length; i++){
            if(i < str.length - 1 && str[i] == '?' && str[i + 1] == '?'){
                if(i == 0){
                    res *= 24;
                    i = 2;
                }
                if(i == 3){
                    res *= 60;
                    i = 4;
                }
            }else if(i == 0 && str[i] == '?'){
                if(str[i + 1] < '4'){
                    res *= 3;
                }else{
                    res *= 2;
                }
            }else{
                if(str[i] == '?'){
                    if(i == 1 && str[0] == '2'){
                        res *= 4;
                    }else{
                        res *= nums[i];
                    }
                }
            }
        }
        return res;
    }
}
