package November_2023;

import java.util.HashMap;
import java.util.Map;
/*
   「HTML 实体解析器」 是一种特殊的解析器, 它将 HTML 代码作为输入, 并用字符本身替换掉所有这些特殊的字符实体.
    HTML 里这些特殊字符和它们对应的字符实体包括：
        双引号：字符实体为 &quot; ，对应的字符是 " 。
        单引号：字符实体为 &apos; ，对应的字符是 ' 。
        与符号：字符实体为 &amp; ，对应对的字符是 & 。
        大于号：字符实体为 &gt; ，对应的字符是 > 。
        小于号：字符实体为 &lt; ，对应的字符是 < 。
        斜线号：字符实体为 &frasl; ，对应的字符是 / 。
    给你输入字符串 text, 请你实现一个 HTML 实体解析器, 返回解析器解析后的结果.
 */
public class entityParser_1410 {
    // 模拟
    public String entityParser(String text) {
        Map<String, Character> map = new HashMap<>();
        map.put("&quot;", '\"');
        map.put("&apos;", '\'');
        map.put("&amp;", '&');
        map.put("&gt;", '>');
        map.put("&lt;", '<');
        map.put("&frasl;", '/');
        StringBuilder sb = new StringBuilder();
        int n = text.length();
        int pos = 0;
        while(pos < n){
            boolean isValid = false;
            if(text.charAt(pos) == '&'){
                for(var entry : map.entrySet()){
                    String e = entry.getKey();
                    char c = entry.getValue();
                    if(pos + e.length() <= text.length() && text.substring(pos, pos + e.length()).equals(e)){
                        sb.append(c);
                        pos += e.length();
                        isValid = true;
                        break;
                    }
                }
            }
            if(!isValid){
                sb.append(text.charAt(pos++));
                continue;
            }
        }
        return sb.toString();
    }
}
