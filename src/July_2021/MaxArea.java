package July_2021;

//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。
//在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。
//找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。

public class MaxArea {
    //双指针
    public int maxArea(int[] height) {
        int len = height.length;
        int max = 0;
        int i = 0,j = len - 1;

        while(i < j){
            int area = (j - i) * (height[i] < height[j] ? height[i++] : height[j--]);
            max = area > max ? area : max;
        }
        return max;
    }
    //双指针优化
    public int maxArea2(int[] height) {
        int len = height.length;
        int max = 0;
        int i = 0,j = len - 1;

        while(i < j){
            int area = (j - i) * (height[i] < height[j] ? height[i] : height[j]);
            max = area > max ? area : max;
            if(height[i] <= height[j]){
                while(height[i] >= height[++i] && i < j){
                }
            }else{
                while(height[j] >= height[--j] && i < j){
                }
            }
        }
        return max;
    }
}

