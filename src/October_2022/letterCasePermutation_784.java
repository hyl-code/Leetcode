package October_2022;

import java.util.ArrayList;
import java.util.List;

/*
    给定一个字符串 s, 通过将字符串 s 中的每个字母转变大小写, 我们可以获得一个新的字符串.
    返回所有可能得到的字符串集合.
    以任意顺序返回输出.
    HINT:
        1 <= s.length <= 12
        s 由小写英文字母, 大写英文字母和数字组成
 */
public class letterCasePermutation_784 {
    List<String> res = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        char[] cs = s.toCharArray();
        bakctrack(cs, 0);
        return res;
    }

    public void bakctrack(char[] cs, int index){
        res.add(String.valueOf(cs));
        for(int i = index; i < cs.length; i++){
            //判断是否为数字, 为数字则跳过
            if(Character.isDigit(cs[i])){
                continue;
            }
            //大小写反转
            cs[i] = (cs[i] >= 'a' && cs[i] <= 'z') ? (char)(cs[i] - 32) : (char)(cs[i] + 32);
            //递归: 对大小写字母进行组合
            bakctrack(cs, i + 1);
            //回溯, 大小写反转回来
            cs[i] = (cs[i] >= 'a' && cs[i] <= 'z') ? (char)(cs[i] - 32) : (char)(cs[i] + 32);
        }
    }
}
