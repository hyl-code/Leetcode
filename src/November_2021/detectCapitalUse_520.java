package November_2021;

/*
    我们定义, 在以下情况时, 单词的大写用法是正确的:
    全部字母都是大写, 比如 "USA" .
    单词中所有字母都不是大写, 比如 "leetcode" .
    如果单词不只含有一个字母, 只有首字母大写, 比如 "Google" .
    给你一个字符串 word . 如果大写用法正确, 返回 true ; 否则, 返回 false .
 */

public class detectCapitalUse_520 {
    public boolean detectCapitalUse(String word) {
        if(word == null || word.length() <= 0)
            return false;
        boolean isUpper = Character.isUpperCase(word.charAt(0));
        int num = 0;
        for(int i = 1; i < word.length(); i++){
            boolean curUpper = Character.isUpperCase(word.charAt(i));
            if(!isUpper){
                if(curUpper)
                    return false;
            }else{
                if(curUpper)
                    num++;
            }
        }
        return num == 0 || num == word.length() - 1;
    }
}
