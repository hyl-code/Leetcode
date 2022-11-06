package November_2022;

/*
    请你设计一个可以解释字符串 command 的 Goal 解析器.
    command 由 "G", "()" 和 "(al)" 按某种顺序组成.
    Goal 解析器会将 "G" 解释为字符串 "G", "()" 解释为字符串 "o", "(al)" 解释为字符串 "al".
    然后, 按原顺序将经解释得到的字符串连接成一个字符串.
    给你字符串 command, 返回 Goal 解析器 对 command 的解释结果.
 */
public class interpret_1678 {
    //嘿嘿...
    public String interpret(String command) {
        return command.replace("()", "o").replace("(al)", "al");
    }

    //循环遍历
    public String interpret2(String command) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < command.length(); i++){
            if(command.charAt(i) == 'G'){
                sb.append("G");
            }else if(command.charAt(i) == '('){
                if(command.charAt(i + 1) == ')'){
                    sb.append("o");
                }else{
                    sb.append("al");
                }
            }
        }
        return sb.toString();
    }
}
