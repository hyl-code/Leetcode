package August_2023;

/*
    给你两个字符串 start 和 target, 长度均为 n.
    每个字符串 仅 由字符 'L'、'R' 和 '_' 组成, 其中：
        字符 'L' 和 'R' 表示片段, 其中片段 'L' 只有在其左侧直接存在一个空位时才能向左移动,
            而片段 'R' 只有在其右侧直接存在一个空位时才能向右移动.
        字符 '_' 表示可以被 任意 'L' 或 'R' 片段占据的空位.
    如果在移动字符串 start 中的片段任意次之后可以得到字符串 target, 返回 true; 否则, 返回 false.
 */
public class canChange_2337 {
    public boolean canChange(String start, String target) {
        if(!start.replaceAll("_", "").equals(target.replaceAll("_", ""))){
            return false;
        }
        for(int i = 0, j = 0; i < start.length(); i++){
            if(start.charAt(i) == '_'){
                continue;
            }
            while(target.charAt(j) == '_'){
                j++;
            }
            // 分类讨论：
            // 如果当前字符为 L 且 i < j, 由于 L 由于无法向右移动, 返回 false
            // 如果当前字符为 R 且 i > j, 由于 R 由于无法向左移动, 返回 false
            if(i != j && (start.charAt(i) == 'L') == (i < j)){
                return false;
            }
            j++;
        }
        return true;
    }
}
