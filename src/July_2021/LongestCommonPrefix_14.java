package July_2021;

public class LongestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String s = strs[0];
        for(String str : strs){
            while(!str.startsWith(s)){
                if(s.length() == 0)
                    return "";

                s = s.substring(0,s.length() - 1);
            }
        }
        return s;
    }
}
