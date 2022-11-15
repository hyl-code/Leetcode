package November_2022;

import java.util.Arrays;
import java.util.Comparator;

/*
    请你将一些箱子装在一辆卡车上. 给你一个二维数组 boxTypes,
    其中 boxTypes[i] = [numberOfBoxes i, numberOfUnitsPerBox i];
    numberOfBoxes i 是类型 i 的箱子的数量.
    numberOfUnitsPerBox i 是类型 i 每个箱子可以装载的单元数量.
    整数 truckSize 表示卡车上可以装载箱子的最大数量.
    只要箱子数量不超过 truckSize, 你就可以选择任意箱子装到卡车上.
    返回卡车可以装载单元的最大总数.
 */
public class maximumUnits_1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return b[1] - a[1];
            }
        });
        //lambda表达式
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int res = 0;
        for(int i = 0; i < boxTypes.length && truckSize > 0; i++){
            if(boxTypes[i][0] < truckSize){
                truckSize -= boxTypes[i][0];
                res += boxTypes[i][0] * boxTypes[i][1];
            }else{
                res += truckSize *  boxTypes[i][1];
                truckSize = 0;
            }
        }
        return res;
    }
}
