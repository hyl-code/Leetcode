package June_2022;

import java.util.ArrayList;
import java.util.List;

/*
    给定一棵二叉树的根节点 root , 请找出该二叉树中每一层的最大值 .
 */

public class largestValues_515 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        if(root == null)
            return new ArrayList<Integer>();
        List<Integer> list = new ArrayList<>();
        dfs(list, root, 0);
        return list;
    }

    public void dfs(List<Integer> list, TreeNode root, int curh){
        if(curh == list.size()){
            list.add(root.val);
        }else{
            //替换操作 存在则报错
            list.set(curh, Math.max(list.get(curh), root.val));
        }
        if(root.left != null){
            dfs(list, root.left, curh + 1);
        }
        if(root.right != null){
            dfs(list, root.right, curh + 1);
        }
    }
}
