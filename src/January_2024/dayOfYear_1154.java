package January_2024;

/*
    给你一个字符串 date, 按 YYYY-MM-DD 格式表示一个现行公元纪年法日期.
    返回该日期是当年的第几天.
 */
public class dayOfYear_1154 {
    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        int[] dayOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){
            dayOfMonth[1]++;
        }

        int res = 0;
        for(int i = 0; i < month - 1; i++){
            res += dayOfMonth[i];
        }
        return res + day;
    }
}
