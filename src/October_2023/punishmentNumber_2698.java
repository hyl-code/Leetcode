package October_2023;

/*
    给你一个正整数 n, 请你返回 n 的 惩罚数.
    n 的惩罚数定义为所有满足以下条件 i 的数的平方和：
        1 <= i <= n
        i * i 的十进制表示的字符串可以分割成若干连续子字符串, 且这些子字符串对应的整数值之和等于 i.
 */
public class punishmentNumber_2698 {
    private static final int[] PRE_SUM = new int[1001];

    static {
        for(int i = 1; i <= 1000; i++){
            char[] s = Integer.toString(i * i).toCharArray();
            PRE_SUM[i] = PRE_SUM[i - 1] + (dfs(s, i, 0, 0) ? i * i : 0);
        }
    }

    private static boolean dfs(char[] s, int i, int p, int sum){
        if(p == s.length){          // 递归终点
            return sum == i;        // i 符合要求
        }
        int x = 0;
        for(int j = p; j < s.length; j++){          // 枚举分割出从 s[p] 到 s[j] 的子串
            x = x * 10 + s[j] - '0';                // 子串对应的整数值
            if(dfs(s, i, j + 1, sum + x)){
                return true;
            }
        }
        return false;
    }

    public int punishmentNumber(int n) {
        return PRE_SUM[n];
    }
}
