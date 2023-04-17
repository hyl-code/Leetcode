package April_2023;

/*
    Alice 和 Bob 计划分别去罗马开会.
    给你四个字符串 arriveAlice, leaveAlice, arriveBob 和 leaveBob.
    Alice 会在日期 arriveAlice 到 leaveAlice 之间在城市里(日期为闭区间),
    而 Bob 在日期 arriveBob 到 leaveBob 之间在城市里(日期为闭区间).
    每个字符串都包含 5 个字符, 格式为 "MM-DD", 对应着一个日期的月和日.
    请你返回 Alice和 Bob 同时在罗马的天数.
    你可以假设所有日期都在同一个自然年, 而且不是闰年.
    每个月份的天数分别为: [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31].
 */
public class countDaysTogether_2409 {
    //根据前缀和计算出每个日子是一年中的第几天
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] prefixSum = new int[13];
        for(int i = 0; i < 12; i++){
            prefixSum[i + 1] = prefixSum[i] + days[i];
        }
        int arrive1 = calculateDayOfYear(arriveAlice, prefixSum);
        int arrive2 = calculateDayOfYear(arriveBob, prefixSum);
        int leave1 = calculateDayOfYear(leaveAlice, prefixSum);
        int leave2 = calculateDayOfYear(leaveBob, prefixSum);
        return Math.max(0, Math.min(leave1, leave2) - Math.max(arrive1, arrive2) + 1);
    }

    public int calculateDayOfYear(String date, int[] prefixSum){
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3));
        return prefixSum[month - 1] + day;
    }
}
