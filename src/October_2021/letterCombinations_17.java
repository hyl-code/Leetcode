package October_2021;

import java.util.ArrayList;
import java.util.List;

/*
    给定一个仅包含数字 2-9 的字符串, 返回所有它能表示的字母组合.
    答案可以按任意顺序返回.
    给出数字到字母的映射如下(与电话按键相同).
    注意 1 不对应任何字母.
 */

public class letterCombinations_17 {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        String []str = new String[digits.length()];

        if(digits == null || digits.isEmpty()){
            return result;
        }

        for(int i = 0; i < digits.length(); i++){
            switch(digits.charAt(i)){
                case '2' : str[i] = "abc";  break;
                case '3' : str[i] = "def";  break;
                case '4' : str[i] = "ghi";  break;
                case '5' : str[i] = "jkl";  break;
                case '6' : str[i] = "mno";  break;
                case '7' : str[i] = "pqrs"; break;
                case '8' : str[i] = "tuv";  break;
                case '9' : str[i] = "wxyz"; break;
            }
        }
        result = combination(str,0,result, "");
        return result;
    }

    public static List<String> combination(String[] str,int n, List<String> list,String temp){
        if(n < str.length - 1){
            for(int j = 0; j < str[n].length(); j++){
                list = combination(str, n+1, list, temp + str[n].charAt(j));
            }
            n++;
        }else{
            for(int j = 0; j < str[n].length(); j++){
                list.add(temp + str[n].charAt(j));
            }
        }
        return list;
    }
}
