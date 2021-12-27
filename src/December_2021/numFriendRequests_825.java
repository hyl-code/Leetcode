package December_2021;

import java.util.Arrays;

/*
    在社交媒体网站上有 n 个用户. 给你一个整数数组 ages , 其中 ages[i] 是第 i 个用户的年龄 .

    如果下述任意一个条件为真, 那么用户 x 将不会向用户 y(x != y)发送好友请求:
    age[y] <= 0.5 * age[x] + 7
    age[y] > age[x]
    age[y] > 100 && age[x] < 100
    否则, x 将会向 y 发送一条好友请求 .

    注意, 如果 x 向 y 发送一条好友请求, y 不必也向 x 发送一条好友请求. 另外, 用户不会向自己发送好友请求.

    返回在该社交媒体网站上产生的好友请求总数。
 */

public class numFriendRequests_825 {
    public int numFriendRequests(int[] ages) {
        int res = 0, len = ages.length;
        Arrays.sort(ages);
        for(int k = 0, i = 0, j = 0; k < len; k++){
            while(i < k && !check(ages[i], ages[k])){
                i++;
            }
            j = j < k ? k : j;
            while(j < len && check(ages[j], ages[k])){
                j++;
            }
            if(j > i){
                res += j - i - 1;
            }
        }
        return res;
    }

    boolean check(int x, int y){
        if(y <= (x / 2) + 7){
            return false;
        }else if(y > x){
            return false;
        }
        return true;
    }
}
