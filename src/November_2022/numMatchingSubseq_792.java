package November_2022;

import java.util.ArrayList;
import java.util.List;

/*
    给定字符串 s 和字符串数组 words, 返回 words[i] 中是 s 的子序列的单词个数.
    字符串的子序列是从原始字符串中生成的新字符串, 可以从中删去一些字符 (可以是 none), 而不改变其余字符的相对顺序.
    例如, "ace" 是 "abcde" 的子序列.
 */
public class numMatchingSubseq_792 {
    public int numMatchingSubseq(String s, String[] words) {
        List<Integer>[] pos = new List[26];
        //初始化
        for(int i = 0; i < 26; i++){
            pos[i] = new ArrayList<Integer>();
        }
        //
        for(int i = 0; i < s.length(); i++){
            pos[s.charAt(i) - 'a'].add(i);
        }
        //初始化 result 数量为所有单词, 如果不满足条件, 则陆续执行减 1 操作
        int res = words.length;
        for(String word : words){
            if(word.length() > s.length()){
                res--;
                continue;
            }
            //将 p 初始化为 -1
            int p = -1;
            //循环遍历每个单词
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(pos[c - 'a'].isEmpty() || pos[c - 'a'].get(pos[c - 'a'].size() - 1) <= p){
                    res--;
                    break;
                }
                //二分寻找 p 的下一个位置
                p = binarySearch(pos[c - 'a'], p);
            }
        }
        return res;
    }

    //二分查找: 找字符串中下一个字符的位置
    public int binarySearch(List<Integer> list, int target){
        int left = 0, right = list.size() - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(list.get(mid) > target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return list.get(left);
    }
}
