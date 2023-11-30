package November_2023;

import java.util.Arrays;
/*
    如果可以使用以下操作从一个字符串得到另一个字符串, 则认为两个字符串接近 ：
        操作 1：交换任意两个现有字符.
            例如, abcde -> aecdb
        操作 2：将一个现有字符的每次出现转换为另一个现有字符, 并对另一个字符执行相同的操作.
            例如, aacabb -> bbcbaa（所有 a 转化为 b, 而所有的 b 转换为 a ）
    你可以根据需要对任意一个字符串多次使用这两种操作.
    给你两个字符串, word1 和 word2. 如果 word1 和 word2 接近, 就返回 true；否则, 返回 false.
 */
public class closeStrings_1657 {
    public boolean closeStrings(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        if(n1 != n2){
            return false;
        }
        int[] cnt1 = new int[26], cnt2 = new int[26];
        for(int i = 0; i < n1; i++){
            cnt1[word1.charAt(i) - 'a']++;
            cnt2[word2.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++){
            if((cnt1[i] == 0 && cnt2[i] != 0) || (cnt1[i] != 0 && cnt2[i] == 0)){
                return false;
            }
        }
        Arrays.sort(cnt1);
        Arrays.sort(cnt2);
        for(int i = 0; i < 26; i++){
            if(cnt1[i] != cnt2[i]){
                return false;
            }
        }
        return true;
    }
}
