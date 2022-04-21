package April_2022;

/*
    给你一个由若干单词组成的句子 sentence, 单词间由空格分隔。每个单词仅由大写和小写英文字母组成 .
    请你将句子转换为 "山羊拉丁文(Goat Latin)"(一种类似于 猪拉丁文 - Pig Latin 的虚构语言).
    山羊拉丁文的规则如下:
        如果单词以元音开头('a', 'e', 'i', 'o', 'u'), 在单词后添加"ma" .
        例如, 单词 "apple" 变为 "applema" .

        如果单词以辅音字母开头(即, 非元音字母), 移除第一个字符并将它放到末尾, 之后再添加"ma" .
        例如, 单词 "goat" 变为 "oatgma" .

        根据单词在句子中的索引, 在单词最后添加与索引相同数量的字母'a', 索引从 1 开始 .
        例如, 在第一个单词后添加 "a", 在第二个单词后添加 "aa", 以此类推 .
    返回将 sentence 转换为山羊拉丁文后的句子 .
 */

public class toGoatLatin_824 {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < words.length; i++){
            char c = words[i].charAt(0);
            if(judge(c)){
                sb.append(words[i]);
            }else{
                sb.append(words[i].substring(1)).append(c);
            }
            sb.append("ma").append("a".repeat(i + 1)).append(" ");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public boolean judge(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
