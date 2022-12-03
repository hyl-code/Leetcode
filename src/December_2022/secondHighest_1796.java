package December_2022;

/*
    给你一个混合字符串 s, 请你返回 s 中第二大的数字, 如果不存在第二大的数字, 请你返回 -1.
    混合字符串由小写英文字母和数字组成.
 */
public class secondHighest_1796 {
    public int secondHighest(String s) {
        int max1 = -1, max2 = -1;
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                int num = s.charAt(i) - '0';
                if(num > max1){
                    max2 = max1;
                    max1 = num;
                }else if(num < max1 && num > max2){
                    max2 = num;
                }
            }
        }
        return max2;
    }
}
