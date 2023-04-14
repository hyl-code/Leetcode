package April_2023;

import java.util.ArrayList;
import java.util.List;

/*
    如果我们可以将小写字母插入模式串 pattern 得到待查询项 query, 那么待查询项与给定模式串匹配.
    (我们可以在任何位置插入每个字符，也可以插入 0 个字符. )
    给定待查询列表 queries, 和模式串 pattern, 返回由布尔值组成的答案列表 answer.
    只有在待查项 queries[i] 与模式串 pattern 匹配时, answer[i] 才为 true, 否则为 false.
 */
public class camelMatch_1023 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> list = new ArrayList<>();
        for(String str : queries){
            list.add(isValid(str, pattern));
        }
        return list;
    }

    public boolean isValid(String str, String pattern){
        if(str.length() < pattern.length()){
            return false;
        }
        int p1, p2 = 0;
        for(p1 = 0; p1 < str.length(); p1++){
            if(p2 < pattern.length() && str.charAt(p1) == pattern.charAt(p2)){
                p2++;
            }else if(str.charAt(p1) <= 'Z'){
                return false;
            }
        }
        return pattern.length() == p2;
    }
}
