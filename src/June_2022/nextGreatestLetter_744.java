package June_2022;

/*
    给你一个排序后的字符列表 letters , 列表中只包含小写英文字母 .
    另给出一个目标字母 target , 请你寻找在这一有序列表里比目标字母大的最小字母 .
    在比较时, 字母是依序循环出现的 .

    举个例子:
        如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b'], 则答案返回 'a'
 */

public class nextGreatestLetter_744 {
    //二分查找
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(letters[mid] - target > 0){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return letters[left % letters.length];
    }
    //线性查找
    public char nextGreatestLetter2(char[] letters, char target) {
        for(char c : letters){
            if(c > target){
                return c;
            }
        }
        return letters[0];
    }
}
