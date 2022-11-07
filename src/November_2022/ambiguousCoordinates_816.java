package November_2022;

import java.util.ArrayList;
import java.util.List;

/*
    我们有一些二维坐标, 如 "(1, 3)" 或 "(2, 0.5)", 然后我们移除所有逗号, 小数点和空格, 得到一个字符串S.
    返回所有可能的原始字符串到一个列表中.
    原始的坐标表示法不会存在多余的零, 所以不会出现类似于 "00", "0.0", "0.00", "1.0", "001", "00.01"或
    一些其他更小的数来表示坐标。
    此外, 一个小数点前至少存在一个数, 所以也不会出现“.1”形式的数字.
    最后返回的列表可以是任意顺序的, 而且注意返回的两个数字中间(逗号之后)都有一个空格.
 */
public class ambiguousCoordinates_816 {
    public List<String> ambiguousCoordinates(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        //将 "()" 去掉, 留下数字部分
        s = s.substring(1, n - 1);
        //枚举 ","出现的位置, 将字符串分为两个部分
        for(int i = 1; i < n - 2; i++){
            List<String> part1 = findSplit(s.substring(0, i));
            List<String> part2 = findSplit(s.substring(i));
            for(String s1 : part1){
                for(String s2 : part2){
                    res.add("(" + s1 + ", " + s2 + ")" );
                }
            }
        }
        return res;
    }

    public List<String> findSplit(String s){
        List<String> list = new ArrayList<>();
        if(s.length() == 1 || s.charAt(0) != '0'){
            list.add(s);
        }
        for(int i = 1; i < s.length(); i++){
            String s1 = s.substring(0, i);
            String s2 = s.substring(i);
            //当整数部分长度不为 1 时, 不能以 '0' 开头
            //小数部分不能以 '0' 结尾
            if((s1.length() == 1 || s.charAt(0) != '0') && s2.charAt(s2.length() - 1) != '0'){
                list.add(s1 + "." + s2);
            }
        }
        return list;
    }
}
