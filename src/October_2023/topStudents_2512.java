package October_2023;

import java.util.*;
/*
    给你两个字符串数组 positive_feedback 和 negative_feedback, 分别包含表示正面的和负面的词汇. 不会有单词同时是正面的和负面的.
    一开始，每位学生分数为 0. 每个正面的单词会给学生的分数加 3 分, 每个负面的词会给学生的分数减 1 分.
    给你 n 个学生的评语, 用一个下标从 0 开始的字符串数组 report 和一个下标从 0 开始的整数数组 student_id 表示,
        其中 student_id[i] 表示这名学生的 ID, 这名学生的评语是 report[i]. 每名学生的 ID 互不相同.
    给你一个整数 k, 请你返回按照得分从高到低最顶尖的 k 名学生. 如果有多名学生分数相同, ID 越小排名越前.
 */
public class topStudents_2512 {
    // 模拟
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Map<String, Integer> words = new HashMap<>();
        for(String word : positive_feedback){
            words.put(word, 3);
        }
        for(String word : negative_feedback){
            words.put(word, -1);
        }
        int n = report.length;
        int[] scores = new int[n];
        int[][] A = new int[n][2];
        for(int i = 0; i < n; i++){
            int score = 0;
            for(String word : report[i].split(" ")){
                score += words.getOrDefault(word, 0);
            }
            A[i] = new int[]{ score, student_id[i] };
        }
        Arrays.sort(A, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < k; i++){
            res.add(A[i][1]);
        }
        return res;
    }
}
