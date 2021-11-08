package October_2021;

import java.util.HashMap;
import java.util.LinkedHashMap;

/*
    罗马数字包含以下七种字符: I, V, X, L, C, D 和 M.

    字符          数值
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

    给你一个整数,将其转为罗马数字.

 */

public class intToRoman_12 {
    public String intToRoman(int num) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        //LinkedHashMap可有序存储数据
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        StringBuilder sb = new StringBuilder();
        for(HashMap.Entry<Integer, String> m : map.entrySet()){
            int val = m.getKey();
            while(num >= val){
                num -= val;
                sb.append(m.getValue());
            }
        }
        return sb.toString();
    }
}
