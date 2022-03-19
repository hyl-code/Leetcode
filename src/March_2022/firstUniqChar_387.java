package March_2022;
import java.util.HashMap;

/*
    给定一个字符串 s, 找到 它的第一个不重复的字符, 并返回它的索引 .
    如果不存在, 则返回 -1 .
 */

public class firstUniqChar_387 {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] str = s.toCharArray();
        for(char c : str){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < str.length; i++){
            if(map.get(str[i]) == 1){
                return i;
            }
        }
        return -1;
    }
}
