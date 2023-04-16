package April_2023;

/*
    设计一个数据结构, 有效地找到给定子数组的多数元素.
    子数组的多数元素是在子数组中出现 threshold 次数或次数以上的元素.
    实现 MajorityChecker 类 :
        MajorityChecker(int[] arr)会用给定的数组 arr 对 MajorityChecker 初始化.
        int query(int left, int right, int threshold)返回子数组中的元素 arr[left...right] 至少出现
    threshold 次数, 如果不存在这样的元素则返回 -1.
 */
public class MajorityChecker_1157 {
    private int[] arr;

    public MajorityChecker_1157(int[] arr) {
        this.arr = arr;
    }

    // 暴力计数器 !
    public int query(int left, int right, int threshold) {
        int[] map = new int[20001];
        for(int i = left; i <= right; i++){
            map[arr[i]]++;
            if(map[arr[i]] >= threshold){
                return arr[i];
            }
        }
        return -1;
    }
}
