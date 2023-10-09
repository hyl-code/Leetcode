package October_2023;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
    给你一个正整数 num, 请你将它分割成两个非负整数 num1 和 num2, 满足：
        num1 和 num2 直接连起来, 得到 num 各数位的一个排列.
        换句话说, num1 和 num2 中所有数字出现的次数之和等于 num 中所有数字出现的次数.
        num1 和 num2 可以包含前导 0.
    请你返回 num1 和 num2 可以得到的和的最小值.

    注意：
        num 保证没有前导 0.
        num1 和 num2 中数位顺序可以与 num 中数位顺序不同.
 */
public class splitNum_2578 {
    public int splitNum(int num) {
        List<Integer> list = new ArrayList<>();
        while(num !=  0){
            list.add(num % 10);
            num /= 10;
        }
        Collections.sort(list);
        int num1 = 0;
        int num2 = 0;
        for(int i = 0; i < list.size(); i++){
            if(i % 2 == 0){
                num1 *= 10;
                num1 += list.get(i);
            }else{
                num2 *= 10;
                num2 += list.get(i);
            }
        }
        return num1 + num2;
    }
}
