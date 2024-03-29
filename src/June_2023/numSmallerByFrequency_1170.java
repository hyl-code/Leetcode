package June_2023;

/*
    定义一个函数 f(s), 统计 s 中（按字典序比较）最小字母的出现频次, 其中 s 是一个非空字符串.
    例如, 若 s = "dcce"，那么 f(s) = 2, 因为字典序最小字母是 "c", 它出现了 2 次.
    现在, 给你两个字符串数组待查表 queries 和词汇表 words.
    对于每次查询 queries[i], 需统计 words 中满足 f(queries[i]) < f(W) 的词的数目, W 表示词汇表 words 中的每个词.
    请你返回一个整数数组 answer 作为答案, 其中每个 answer[i] 是第 i 次查询的结果.
 */
public class numSmallerByFrequency_1170 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] q = new int[queries.length];
        int[] w = new int[words.length];
        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            q[i] = countSmaller(queries[i]);
        }
        for(int i = 0; i < words.length; i++){
            w[i] = countSmaller(words[i]);
        }
        for(int i = 0; i < queries.length; i++){
            int cnt = 0;
            for(int j = 0; j < words.length; j++){
                if(q[i] < w[j]){
                    cnt++;
                }
            }
            res[i] = cnt;
        }
        return res;
    }

    public int countSmaller(String str){
        int cnt = 1;
        char c = str.charAt(0);
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) < c){
                c = str.charAt(i);
                cnt = 1;
            }else if(str.charAt(i) == c){
                cnt++;
            }
        }
        return cnt;
    }
}
