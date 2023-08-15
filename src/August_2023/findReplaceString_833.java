package August_2023;

import java.util.Arrays;
/*
    你会得到一个字符串 s (索引从 0 开始), 你必须对它执行 k 个替换操作.
    替换操作以三个长度均为 k 的并行数组给出：indices, sources, targets.
    要完成第 i 个替换操作：
        检查子字符串 sources[i] 是否出现在原字符串 s 的索引 indices[i] 处.
        如果没有出现, 什么也不做.
        如果出现, 则用 targets[i] 替换该子字符串.

    例如, 如果 s = "abcd", indices[i] = 0, sources[i] = "ab",  targets[i] = "eee", 那么替换的结果将是 "eeecd".
    所有替换操作必须同时发生, 这意味着替换操作不应该影响彼此的索引, 测试用例保证元素间不会重叠.
    例如, 一个 s = "abc", indices = [0,1], sources = ["ab"，"bc"] 的测试用例将不会生成, 因为 "ab" 和 "bc" 替换重叠.
    在对 s 执行所有替换操作后返回结果字符串.
    子字符串是字符串中连续的字符序列.
 */
public class findReplaceString_833 {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length();
        String[] replaceStr = new String[n];        // 替换字符串
        int[] replaceLen = new int[n];              // 被替换长度
        Arrays.fill(replaceLen, 1);
        for(int i = 0; i < indices.length; i++){
            int idx = indices[i];
            if(s.startsWith(sources[i], idx)){
                replaceStr[idx] = targets[i];
                replaceLen[idx] = sources[i].length();
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i += replaceLen[i]){
            if(replaceStr[i] == null){
                sb.append(s.charAt(i));
            }else{
                sb.append(replaceStr[i]);
            }
        }
        return sb.toString();
    }
}
