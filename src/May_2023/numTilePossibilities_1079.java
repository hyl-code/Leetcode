package May_2023;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
    你有一套活字字模 tiles, 其中每个字模上都刻有一个字母 tiles[i].
    返回你可以印出的非空字母序列的数目.
    注意：本题中, 每个活字字模只能使用一次.
 */
public class numTilePossibilities_1079 {
    public int numTilePossibilities(String tiles) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : tiles.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Set<Character> set = new HashSet<>(map.keySet());
        return dfs(tiles.length(), map, set) - 1;
    }

    public int dfs(int i, Map<Character, Integer> map, Set<Character> set){
        if(i == 0){
            return 1;
        }
        int res = 1;            //不取后面的字符, 也是一个解
        for(char c : set){
            if(map.get(c) > 0){
                map.put(c, map.get(c) - 1);
                res += dfs(i - 1, map, set);
                map.put(c, map.get(c) + 1);
            }
        }
        return res;
    }
}
