package October_2022;

/*
    给你长度相等的两个字符串 s1 和 s2 .
    一次字符串交换操作的步骤如下: 选出某个字符串中的两个下标(不必不同), 并交换这两个下标所对应的字符.
    如果对其中一个字符串执行最多一次字符串交换就可以使两个字符串相等, 返回 true; 否则, 返回 false.
 */
public class areAlmostEqual_1790 {
    //计数
    public boolean areAlmostEqual(String s1, String s2) {
        int m = -1, n = -1;
        int count = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                count++;
                if(m == -1){
                    m = i;
                }else if(n == -1){
                    n = i;
                }
            }
        }
        if(count == 0){
            return true;
        }
        if(count == 2 && (s1.charAt(m) == s2.charAt(n) && s1.charAt(n) == s2.charAt(m))){
            return true;
        }
        return false;
    }
}
