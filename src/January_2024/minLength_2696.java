package January_2024;

import java.util.ArrayList;
import java.util.List;
/*
    给你一个仅由大写英文字符组成的字符串 s.
    你可以对此字符串执行一些操作, 在每一步操作中, 你可以从 s 中删除任一个 "AB" 或 "CD" 子字符串.
    通过执行操作, 删除所有 "AB" 和 "CD" 子串, 返回可获得的最终字符串的最小可能长度.
    注意, 删除子串后, 重新连接出的字符串可能会产生新的 "AB" 或 "CD" 子串.
 */
public class minLength_2696 {
    public int minLength(String s) {
        List<Character> stack = new ArrayList<Character>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            stack.add(c);
            int m = stack.size();
            if(m >= 2 && (stack.get(m - 2) == 'A' && stack.get(m - 1) == 'B' || stack.get(m - 2) == 'C' && stack.get(m - 1) == 'D')){
                stack.remove(m - 1);
                stack.remove(m - 2);
            }
        }
        return stack.size();
    }
}
