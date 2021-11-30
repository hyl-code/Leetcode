package November_2021;

import java.util.ArrayList;
import java.util.List;

/*

 */

public class generateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        combination(res, "", 0, 0, n);
        //  count1:左括号数       count2:右括号数
        return res;
    }

    public void combination(List<String> res, String str,int count1, int count2, int n){
        if(count1 > n || count2 > n)
            return;
        if(count1 == n && count2 == n)
            res.add(str);
        if(count1 >= count2){
            String str1 = new String(str);
            combination(res, str + "(", count1 + 1, count2, n);
            combination(res, str1 + ")", count1, count2 + 1, n);
        }
    }
}
