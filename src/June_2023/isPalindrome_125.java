package June_2023;

/*
    如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后, 短语正着读和反着读都一样, 则可以认为该短语是一个回文串.
    字母和数字都属于字母数字字符.
    给你一个字符串 s, 如果它是回文串, 返回 true；否则, 返回 false .
 */
public class isPalindrome_125 {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= 'A' && c <= 'Z'){
                sb.append((char)(c - 'A' + 'a'));
            }else if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')){
                sb.append(c);
            }
        }
        return sb.toString().equals(sb.reverse().toString());
    }
}
