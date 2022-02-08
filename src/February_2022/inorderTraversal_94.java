package February_2022;

import java.util.ArrayList;
import java.util.List;

/*
    给定一个二叉树的根节点 root , 返回它的中序遍历 .
 */

public class inorderTraversal_94 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res){
        if(root == null){
            return ;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
