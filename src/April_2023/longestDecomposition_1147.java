package April_2023;

/*
    你会得到一个字符串 text. 你应该把它分成 k 个子字符串 (subtext1, subtext2, ...,  subtextk), 要求满足:
        subtexti 是非空字符串
        所有子字符串的连接等于 text ( 即subtext1 + subtext2 + ... + subtextk == text)
        对于所有 i 的有效值(即 1 <= i <= k ), subtexti == subtextk - i + 1 均成立
    返回 k 可能最大值.
 */
public class longestDecomposition_1147 {
    public int longestDecomposition(String text) {
        int res = 0;
        while(!text.isEmpty()){
            int i = 1, n = text.length();
            while(i <= n/ 2 && !text.substring(0, i).equals(text.substring(n - i))){
                i++;
            }
            if(i > n / 2){
                res++;
                break;
            }
            res += 2;
            text = text.substring(i, n - i);
        }
        return res;
    }

    public int longestDecomposition1(String text) {
        if(text.isEmpty()){
            return 0;
        }
        int n = text.length();
        for(int i = 1; i <= n / 2; i++){
            if(text.substring(0, i).equals(text.substring(n - i))){
                return 2 + longestDecomposition(text.substring(i, n - i));
            }
        }
        return 1;
    }
}
