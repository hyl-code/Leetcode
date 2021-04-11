package April_2021;

    //264.给你一个整数n，请你找出并返回第n个丑数。

    //丑数就是只包含质因数2、3和/或5的正整数。

public class Ugly_NumberII {
    public int nthUglyNumber(int n) {
        int[] num = new int[n];
        int a1 = 0,a2 = 0,a3 = 0;

        num[0] = 1;

        for(int i = 1;i < n;i++){
            num[i] = Math.min(2 * num[a1],3 * num[a2]);
            num[i] = Math.min(num[i],5 * num[a3]);

            if(2 * num[a1] == num[i]){
                a1++;
            }

            if(3 * num[a2] == num[i]){
                a2++;
            }

            if(5 * num[a3] == num[i]){
                a3++;
            }
        }

        return num[n - 1];
    }
}
