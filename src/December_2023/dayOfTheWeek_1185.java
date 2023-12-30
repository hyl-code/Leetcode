package December_2023;

/*
    给你一个日期, 请你设计一个算法来判断它是对应一周中的哪一天.
    输入为三个整数：day、month 和 year, 分别表示日、月、年.
    您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.
 */
public class dayOfTheWeek_1185 {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        int days = 365 * (year - 1971) + (year - 1969) / 4;
        for(int i = 0; i < month - 1; i++){
            days += monthDays[i];
        }
        if((year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) && month >= 3){
            days += 1;
        }
        days += day;
        return week[(days + 3) % 7];
    }
}
