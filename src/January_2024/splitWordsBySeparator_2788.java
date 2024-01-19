package January_2024;

import java.util.ArrayList;
import java.util.List;
/*
    给你一个字符串数组 words 和一个字符 separator, 请你按 separator 拆分 words 中的每个字符串.
    返回一个由拆分后的新字符串组成的字符串数组, 不包括空字符串.
    注意：
        separator 用于决定拆分发生的位置，但它不包含在结果字符串中.
        拆分可能形成两个以上的字符串.
        结果字符串必须保持初始相同的先后顺序.
 */
public class splitWordsBySeparator_2788 {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> list = new ArrayList<>();
        for(String word : words){
            StringBuilder sb = new StringBuilder();
            int len = word.length();
            for(int i = 0; i < len; i++){
                char c = word.charAt(i);
                if(c == separator){
                    if(sb.length() > 0){
                        list.add(sb.toString());
                        sb.setLength(0);
                    }
                }else{
                    sb.append(c);
                }
            }
            if(sb.length() > 0){
                list.add(sb.toString());
            }
        }
        return list;
    }
}
