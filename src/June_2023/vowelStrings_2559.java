package June_2023;

/*
    给你一个下标从 0 开始的字符串数组 words 以及一个二维整数数组 queries.
    每个查询 queries[i] = [li, ri] 会要求我们统计在 words 中下标在 li 到 ri 范围内（包含 这两个值）并且以元音开头和结尾的字符串的数目.
    返回一个整数数组, 其中数组的第 i 个元素对应第 i 个查询的答案.
    注意：元音字母是 'a'、'e'、'i'、'o' 和 'u'.
 */
public class vowelStrings_2559 {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] cnt = new int[words.length + 1];
        int[] res = new int[queries.length];
        //计数：cnt[i] = 前 i 个字符串符合条件的数目.
        cnt[0] = 0;
        for(int i = 0; i < words.length; i++){
            cnt[i + 1] = cnt[i] + isValid(words[i]);
        }
        //通过相减得到从 l 到 r 范围内符合条件的字符串的数目.
        for(int i = 0; i < queries.length; i++){
            int l = queries[i][0], r = queries[i][1];
            res[i] = cnt[r + 1] - cnt[l];
        }
        return res;
    }

    public int isValid(String word){
        int c = word.charAt(0);
        if(c != 'a' && c != 'e' && c != 'i' && c != 'o'&& c != 'u'){
            return 0;
        }
        c = word.charAt(word.length() - 1);
        if(c != 'a' && c != 'e' && c != 'i' && c != 'o'&& c != 'u'){
            return 0;
        }
        return 1;
    }
}
