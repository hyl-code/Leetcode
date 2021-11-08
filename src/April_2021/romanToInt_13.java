package April_2021;

import java.util.HashMap;

    //罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
    //字符          数值
    //   I             1
    //   V             5
    //  X             10
    //  L             50
    //  C             100
    //  D             500
    //  M             1000
    //I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
    //X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
    //C可以放在D(500) 和M(1000) 的左边，来表示400 和900。

public class romanToInt_13 {
    public int romanToInt(String s) {
        int sum = 0;
        char[] str = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();

        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        for(int i = 0;i < str.length;i++){
            if(i < str.length - 1 && map.get(str[i]) < map.get(str[i + 1])){
                sum -= map.get(str[i]);
            }else{
                sum += map.get(str[i]);
            }
        }
        if(sum < 1 || sum > 3999){
            System.out.println("Error!");
        }else{
            return sum;
        }
        return 0;
    }
}
