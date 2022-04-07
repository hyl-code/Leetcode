package April_2022;

/*
    给定两个字符串, s 和 goal. 如果在若干次旋转操作之后, s 能变成 goal, 那么返回 true .
    s 的 旋转操作 就是将 s 最左边的字符移动到最右边 .
    例如, 若 s = 'abcde', 在旋转一次之后结果就是'bcdea' .
 */

public class rotateString_796 {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length())
            return false;
        for(int i = 0; i < s.length(); i++){
            boolean flag = true;
            for(int j = 0; j < goal.length(); j++){
                if(s.charAt((i + j) % s.length()) != goal.charAt(j)){
                    flag = false;
                    break;
                }
            }
            if(flag)
                return true;
        }
        return false;
    }

    public boolean rotateString1(String s, String goal){
        return (s.length() == goal.length()) && (s + s).contains(goal);
    }
}
