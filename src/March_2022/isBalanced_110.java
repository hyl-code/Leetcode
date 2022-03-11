package March_2022;

/*
    给定一个二叉树, 判断它是否是高度平衡的二叉树 .
    本题中, 一棵高度平衡二叉树定义为:
    一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1 .
 */

public class isBalanced_110 {
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

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if(Math.abs(depth(root.left) - depth(root.right)) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = depth(node.left);
        int right = depth(node.right);
        return Math.max(left, right) + 1;
    }
}
