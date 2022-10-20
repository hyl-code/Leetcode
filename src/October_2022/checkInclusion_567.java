package October_2022;
import java.util.HashMap;

/*
    给你两个字符串 s1 和 s2, 写一个函数来判断 s2 是否包含 s1 的排列.
    如果是, 返回 true; 否则, 返回 false.
    换句话说, s1 的排列之一是 s2 的子串.
 */
public class checkInclusion_567 {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int left = 0, right = 0;
        //窗口中满足 s1 要求的字符个数
        int valid = 0;
        while(right < s2.length()){
            char c = s2.charAt(right);
            //向右扩大窗口
            right++;
            if(map.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                //当字符 c 满足 s1 的要求
                if(window.get(c).equals(map.get(c))){
                    valid++;
                }
            }
            //到达最大窗口, 开始收缩窗口
            if(right - left == s1.length()){
                //窗口中元素是 s1 的一个排列
                if(valid == map.size()){
                    return true;
                }
                char ch = s2.charAt(left);
                //收缩窗口
                left++;
                if(map.containsKey(ch)){
                    //下一步 ch 的个数 - 1 后就不满足了, 有效元素 - 1
                    if(window.get(ch).equals(map.get(ch))){
                        valid--;
                    }
                    window.put(ch, window.get(ch) - 1);
                }
            }
        }
        return false;
    }
}
