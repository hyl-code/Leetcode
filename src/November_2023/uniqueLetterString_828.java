package November_2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
    我们定义了一个函数 countUniqueChars(s) 来统计字符串 s 中的唯一字符, 并返回唯一字符的个数.
    例如：s = "LEETCODE", 则其中 "L", "T","C","O","D" 都是唯一字符, 因为它们只出现一次, 所以 countUniqueChars(s) = 5.
    本题将会给你一个字符串 s, 我们需要返回 countUniqueChars(t) 的总和, 其中 t 是 s 的子字符串. 输入用例保证返回值为 32 位整数.
    注意, 某些子字符串可能是重复的, 但你统计时也必须算上这些重复的子字符串（也就是说, 你必须统计 s 的所有子字符串中的唯一字符）.
 */
public class uniqueLetterString_828 {
    public int uniqueLetterString(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        char[] cs = s.toCharArray();
        for(int i = 0; i < cs.length; i++){
            if(!map.containsKey(cs[i])){
                map.put(cs[i], new ArrayList<>());
            }
            map.get(cs[i]).add(i);                  // 统计每个字符的出现位置
        }
        int res = 0;
        // 遍历哈希, 分出每个字符的区间, 计算它的贡献
        for(Map.Entry<Character, List<Integer>> entry : map.entrySet()){
            List<Integer> list = entry.getValue();
            int head = -1, tail = -1;
            for(int i = 0; i < list.size(); i++){
                tail = (i < list.size() - 1) ? list.get(i + 1) : cs.length;
                res += (list.get(i) - head) * (tail - list.get(i));
                head = list.get(i);
            }
        }
        return res;
    }
}
