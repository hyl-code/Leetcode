package October_2022;

/*
    学校的自助午餐提供圆形和方形的三明治, 分别用数字 0 和 1 表示.
    所有学生站在一个队列里, 每个学生要么喜欢圆形的要么喜欢方形的.
    餐厅里三明治的数量与学生的数量相同.
    所有三明治都放在一个栈里, 每一轮:
    如果队列最前面的学生喜欢栈顶的三明治, 那么会拿走它并离开队列.
    否则, 这名学生会放弃这个三明治并回到队列的尾部.
    这个过程会一直持续到队列里所有学生都不喜欢栈顶的三明治为止.
    给你两个整数数组 students 和 sandwiches, 其中 sandwiches[i] 是栈里面第 i 个三明治的类型(i = 0 是栈的顶部),
    students[j]是初始队列里第 j 名学生对三明治的喜好(j = 0 是队列的最开始位置). 请你返回无法吃午餐的学生数量.
 */
public class countStudents_1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] cnt = new int[2];
        for(int student : students){
            cnt[student]++;
        }
        for(int sandwich : sandwiches){
            //顺序循环进行判断
            //若有该类型三明治, 则数量 - 1
            if(cnt[sandwich] > 0){
                cnt[sandwich]--;
            }else{
                //若没有该类型三明治, 说明队列里所有学生都不喜欢栈顶的三明治, 循环结束
                break;
            }
        }
        return cnt[0] + cnt[1];
    }
}
