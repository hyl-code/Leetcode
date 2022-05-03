package May_2022;

import java.util.Arrays;

/*
    给你一个日志数组 logs.
    每条日志都是以空格分隔的字串, 其第一个字为字母与数字混合的标识符 .

    有两种不同类型的日志:
        字母日志: 除标识符之外，所有字均由小写字母组成
        数字日志: 除标识符之外，所有字均由数字组成

    请按下述规则将日志重新排序:
        所有 字母日志 都排在 数字日志 之前 .
        字母日志 在内容不同时, 忽略标识符后, 按内容字母顺序排序; 在内容相同时, 按标识符排序 .
        数字日志 应该保留原来的相对顺序 .
    返回日志的最终顺序 .
 */
public class reorderLogFiles_937 {
    public String[] reorderLogFiles(String[] logs) {
        Pair[] arr = new Pair[logs.length];
        String[] res = new String[logs.length];
        for(int i = 0; i < logs.length; i++){
            arr[i] = new Pair(logs[i], i);
        }
        Arrays.sort(arr, (a, b) -> Compare(a, b));
        for(int i = 0; i < logs.length; i++){
            res[i] = arr[i].log;
        }
        return res;
    }

    public int Compare(Pair pair1, Pair pair2){
        String log1 = pair1.log, log2 = pair2.log;
        int index1 = pair1.index, index2 = pair2.index;
        String[] split1 = log1.split(" ", 2);
        String[] split2 = log2.split(" ", 2);
        boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
        boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
        if(isDigit1 && isDigit2){
            return index1 - index2;
        }
        if(!isDigit1 && !isDigit2){
            int flag = split1[1].compareTo(split2[1]);
            if(flag != 0)
                return flag;
            return split1[0].compareTo(split2[0]);
        }
        return isDigit1 ? 1 : -1;
    }
}

class Pair{
    String log;
    int index;

    public Pair(String log, int index){
        this.log = log;
        this.index = index;
    }
}
