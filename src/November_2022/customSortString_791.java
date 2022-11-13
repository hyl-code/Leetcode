package November_2022;

/*
    给定两个字符串 order 和 s. order 的所有单词都是唯一的, 并且以前按照一些自定义的顺序排序.
    对 s 的字符进行置换, 使其与排序的 order 相匹配.
    更具体地说, 如果在 order 中的字符 x 出现字符 y 之前, 那么在排列后的字符串中, x 也应该出现在 y 之前.
    返回满足这个性质的 s 的任意排列.
 */
public class customSortString_791 {
    public String customSortString(String order, String s) {
        int[] cnt = new int[26];
        for(char c : s.toCharArray()){
            cnt[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(char c : order.toCharArray()){
            while(cnt[c - 'a']-- > 0){
                sb.append(c);
            }
        }
        for(int i = 0; i < 26; i++){
            while(cnt[i]-- > 0){
                sb.append((char)(i + 'a'));
            }
        }
        return sb.toString();
    }
}
