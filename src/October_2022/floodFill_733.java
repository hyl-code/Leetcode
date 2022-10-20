package October_2022;

/*
    有一幅以 m x n 的二维整数数组表示的图画 image, 其中 image[i][j] 表示该图画的像素值大小.
    你也被给予三个整数 sr, sc 和 newColor. 你应该从像素 image[sr][sc] 开始对图像进行上色填充.
    为了完成上色工作, 从初始像素开始, 记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点,
    接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点, ……, 重复该过程.
    将所有有记录的像素点的颜色值改为 newColor.
    最后返回经过上色渲染后的图像.
 */
public class floodFill_733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr, sc, color, image[sr][sc]);
        return image;
    }
    //深度优先算法
    public void dfs(int[][] image, int i, int j, int color, int oldColor){
        if(i < 0 || i >= image.length || j < 0 || j >= image[0].length){
            return;
        }
        if(image[i][j] != oldColor || image[i][j] == color){
            return;
        }
        image[i][j] = color;
        dfs(image, i + 1, j, color, oldColor);
        dfs(image, i - 1, j, color, oldColor);
        dfs(image, i, j + 1, color, oldColor);
        dfs(image, i, j - 1, color, oldColor);
    }
}
