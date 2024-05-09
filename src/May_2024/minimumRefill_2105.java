package May_2024;

/*
    Alice 和 Bob 打算给花园里的 n 株植物浇水. 植物排成一行，从左到右进行标记，编号从 0 到 n - 1. 其中，第 i 株植物的位置是 x = i.
    每一株植物都需要浇特定量的水. Alice 和 Bob 每人有一个水罐，最初是满的. 他们按下面描述的方式完成浇水：
         Alice 按从左到右的顺序给植物浇水，从植物 0 开始. Bob 按从右到左的顺序给植物浇水，从植物 n - 1 开始. 他们同时给植物浇水.
        无论需要多少水，为每株植物浇水所需的时间都是相同的.
        如果 Alice/Bob 水罐中的水足以完全灌溉植物，他们必须给植物浇水. 否则，他们首先（立即）重新装满罐子，然后给植物浇水.
        如果 Alice 和 Bob 到达同一株植物，那么当前水罐中水更多的人会给这株植物浇水. 如果他俩水量相同，那么 Alice 会给这株植物浇水.
    给你一个下标从 0 开始的整数数组 plants ，数组由 n 个整数组成. 其中，plants[i] 为第 i 株植物需要的水量.
    另有两个整数 capacityA 和 capacityB 分别表示 Alice 和 Bob 水罐的容量. 返回两人浇灌所有植物过程中重新灌满水罐的次数.
 */
public class minimumRefill_2105 {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int i = 0, j = plants.length - 1;
        int restA = capacityA, restB = capacityB;
        int res = 0;
        while (i < j) {
            if (restA >= plants[i]) {
                restA -= plants[i];
            } else {
                res++;
                restA = capacityA - plants[i];
            }
            i++;
            if (restB >= plants[j]) {
                restB -= plants[j];
            } else {
                res++;
                restB = capacityB - plants[j];
            }
            j--;
        }
        if (i == j) {
            if ((restA >= restB && restA < plants[i]) || (restA < restB && restB < plants[j])) {
                res++;
            }
        }
        return res;
    }
}
