package September_2022;

/*
    字符串轮转:
    给定两个字符串s1和s2, 请编写代码检查s2是否为s1旋转而成
    (比如, waterbottle是erbottlewat旋转后的字符串 ).
 */
public class isFlipedString_01_09 {
    public boolean isFlipedString(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        String ss = s2 + s2;
        return ss.contains(s1);
    }

    //模拟
    public boolean isFlipedString2(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        int len = s1.length();
        if(len == 0){
            return true;
        }
        for(int i = 0; i < len; i++){
            boolean flag = true;
            for(int j = 0; j < len; j++){
                if(s1.charAt((i + j) % len) != s2.charAt(j)){
                    flag = false;
                    break;
                }
            }
            if(flag == true){
                return true;
            }
        }
        return false;
    }
}
