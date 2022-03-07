package March_2022;

/*
    给定一个整数 num, 将其转化为 7 进制, 并以字符串形式输出.
 */

public class convertToBase7_504 {
    public String convertToBase7(int num) {
        if(num == 0)
            return "0";
        StringBuilder sb = new StringBuilder();
        Boolean flag = num < 0;
        num = Math.abs(num);
        while(num != 0){
            sb.append(num % 7);
            num /= 7;
        }
        if(flag){
            sb.append("-");
        }
        return sb.reverse().toString();
    }
}
