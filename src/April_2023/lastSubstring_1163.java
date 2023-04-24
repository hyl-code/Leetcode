package April_2023;

/*
    给你一个字符串 s, 找出它的所有子串并按字典序排列, 返回排在最后的那个子串.
 */
public class lastSubstring_1163 {
    //双指针
    public String lastSubstring(String s) {
        int i = 0, j = 1, n = s.length();
        while(j < n){
            int k = 0;
            while(j + k < n && s.charAt(i + k) == s.charAt(j + k)){
                k++;
            }
            if(j + k < n && s.charAt(i + k) < s.charAt(j + k)){
                int temp = i;
                i = j;
                //当 s[i + k] < s[j + k] 且 i + k > j 时, 设 m < k, s(i+m) < s(j+m)
                //所以可以直接跳过, 无需比较.
                j = Math.max(j + 1, temp + k + 1);
            }else{
                j = j + k + 1;
            }
        }
        return s.substring(i);
    }
}
