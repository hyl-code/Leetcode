package March_2022;

/*
    给你一个二叉树的根节点 root , 检查它是否轴对称 .
 */

public class isSymmetric_101 {
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

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1 == null || node2 == null || node1.val != node2.val){
            return false;
        }
        return compare(node1.left, node2.right) && compare(node1.right, node2.left);
    }
}
