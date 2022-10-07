package October_2022;

/*
    给定一个字符串 s, 你需要反转字符串中每个单词的字符顺序, 同时仍保留空格和单词的初始顺序.
 */
public class reverseWords_557 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] str = s.split(" ");
        for(int i = 0; i < str.length; i++){
            str[i] = reverse(str[i]);
            sb.append(str[i]);
            if(i < str.length - 1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public String reverse(String s){
        char[] str = s.toCharArray();
        int left = 0, right = str.length - 1;
        while(left < right){
            char c = str[left];
            str[left++] = str[right];
            str[right--] = c;
        }
        return new String(str);
    }
}
