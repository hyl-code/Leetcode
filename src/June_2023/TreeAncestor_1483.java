package June_2023;

import java.util.Arrays;

/*
    给你一棵树, 树上有 n 个节点, 按从 0 到 n - 1 编号.
    树以父节点数组的形式给出, 其中 parent[i] 是节点 i 的父节点. 树的根节点是编号为 0 的节点.
    树节点的第 k 个祖先节点是从该节点到根节点路径上的第 k 个节点.
    实现 TreeAncestor 类：
        TreeAncestor(int n， int[] parent) 对树和父数组中的节点数初始化对象.
        getKthAncestor(int node, int k) 返回节点 node 的第 k 个祖先节点. 如果不存在这样的祖先节点, 返回 -1.
 */
public class TreeAncestor_1483 {
    int[][] ancestors;
    public TreeAncestor_1483(int n, int[] parent) {
        //树最多有 50000 个节点, 因此可以设 ancestor 的第二维度为 16.
        ancestors = new int[n][16];
        for(int i = 0; i < n; i++){
            Arrays.fill(ancestors[i], -1);
        }
        for(int i = 0; i < n; i++){
            ancestors[i][0] = parent[i];
        }
        for(int j = 1; j < 16; j++){
            for(int i = 0; i < n; i++){
                //当前节点的第 2^j 个祖先是他第 2^(j-1) 个祖先的第 2^(j-1) 个祖先.
                if(ancestors[i][j - 1] != -1){
                    ancestors[i][j] = ancestors[ancestors[i][j - 1]][j - 1];
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for(int j = 0; j < 16; j++){
            if(((k >> j) & 1) != 0){
                node = ancestors[node][j];
                if(node == -1){
                    return -1;
                }
            }
        }
        return node;
    }
}
