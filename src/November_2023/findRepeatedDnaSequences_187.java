package November_2023;

import java.util.*;
/*
    DNA序列由一系列核苷酸组成, 缩写为 'A', 'C', 'G' 和 'T'.
        例如, "ACGAATTCCG" 是一个 DNA 序列.
    在研究 DNA 时, 识别 DNA 中的重复序列非常有用.
    给定一个表示 DNA 序列的字符串 s, 返回所有在 DNA 分子中出现不止一次的长度为 10 的序列(子字符串).
    你可以按任意顺序返回答案.
 */
public class findRepeatedDnaSequences_187 {
    static final int L = 10;

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> cnt = new HashMap<>();
        int n = s.length();
        for(int i = 0; i <= n - L; i++){
            String sub = s.substring(i, i + L);
            cnt.put(sub, cnt.getOrDefault(sub, 0) + 1);
            if(cnt.get(sub) == 2){
                res.add(sub);
            }
        }
        return res;
    }
}
