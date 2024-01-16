package January_2024;

import java.util.HashSet;
import java.util.Set;
/*
    给你一个下标从 0 开始的数组 words, 数组中包含互不相同的字符串.
    如果字符串 words[i] 与字符串 words[j] 满足以下条件, 我们称它们可以匹配：
        字符串 words[i] 等于 words[j] 的反转字符串.
        0 <= i < j < words.length
    请你返回数组 words 中的最大匹配数目.
    注意, 每个字符串最多匹配一次.
 */
public class maximumNumberOfStringPairs_2744 {
    public int maximumNumberOfStringPairs(String[] words) {
        int n = words.length;
        int res = 0;
        Set<Integer> seen = new HashSet<>();
        for(int i = 0; i < n; i++){
            if(seen.contains(words[i].charAt(1) * 100 + words[i].charAt(0))){
                res++;
            }
            seen.add(words[i].charAt(0) * 100 + words[i].charAt(1));
        }
        return res;
    }
}
