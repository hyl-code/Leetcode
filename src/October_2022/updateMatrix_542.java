package October_2022;

public class updateMatrix_542 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        //初始化
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    res[i][j] = 0;
                }else{
                    //设为可能的最大值
                    res[i][j] = m + n;
                }
            }
        }
        boolean flag = true;
        //本次循环是否有更新数据
        while(flag){
            flag = false;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    //单元值为 1 时, 计算距离
                    if(mat[i][j] == 1){
                        int temp = res[i][j];
                        //左
                        if(i > 0){
                            res[i][j] = Math.min(res[i][j], res[i - 1][j] + 1);
                        }
                        //右
                        if(i < m - 1){
                            res[i][j] = Math.min(res[i][j], res[i + 1][j] + 1);
                        }
                        //上
                        if(j > 0){
                            res[i][j] = Math.min(res[i][j], res[i][j - 1] + 1);
                        }
                        //下
                        if(temp != res[i][j]){
                            flag = true;
                        }
                    }
                }
            }
        }
        return res;
    }
}
