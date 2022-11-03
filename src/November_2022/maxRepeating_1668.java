package November_2022;

/*
    给你一个字符串 sequence, 如果字符串 word 连续重复 k 次形成的字符串是 sequence 的一个子字符串,
    那么单词 word 的 重复值为 k.
    单词 word 的最大重复值是单词 word 在 sequence 中最大的重复值.
    如果 word 不是 sequence 的子串, 那么重复值 k 为 0.
    给你一个字符串 sequence 和 word, 请你返回最大重复值 k.
 */
public class maxRepeating_1668 {
    public int maxRepeating(String sequence, String word) {
        int len = word.length(), sLen = sequence.length();
        if(len > sLen){
            return 0;
        }
        if(sequence.equals(word)){
            return 1;
        }
        int res = 0;
        int left = 0;
        int count = 0;
        boolean flag = false;
        while(left <= sLen - len){
            if(sequence.substring(left, left + len).equals(word)){
                count++;
                left += len;
                flag = true;
            }else{
                //如果上一次有匹配, 那就需要回到上一次节点的开始
                if(flag){
                    left = left - len + 1;
                    flag = false;
                }else{
                    left++;
                }
                res = Math.max(count, res);
                count = 0;
            }
        }
        res = Math.max(count, res);
        return res;
    }
}
