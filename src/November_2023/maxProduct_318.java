package November_2023;

/*
    给你一个字符串数组 words, 找出并返回 length(words[i]) * length(words[j]) 的最大值, 并且这两个单词不含有公共字母.
    如果不存在这样的两个单词, 返回 0.
 */
public class maxProduct_318 {
    // 位运算
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] masks = new int[n];
        // 位运算预处理单词
        for(int i = 0; i < n; i++){
            String word = words[i];
            int len = word.length();
            for(int j = 0; j < len; j++){
                masks[i] |= 1 << (word.charAt(j) - 'a');
            }
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                // 通过 & 运算判断是否有相同字母
                if((masks[i] & masks[j]) == 0){
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}
