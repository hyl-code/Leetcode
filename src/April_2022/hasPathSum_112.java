package April_2022;

/*
    给你二叉树的根节点 root 和一个表示目标和的整数 targetSum .
    判断该树中是否存在 根节点到叶子节点 的路径, 这条路径上所有节点值相加等于目标和 targetSum .
    如果存在, 返回 true ; 否则, 返回 false .
    叶子节点 是指没有子节点的节点 .
 */

public class hasPathSum_112 {
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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum;
        if(root == null)
            return false;
        if(root.left == null && root.right == null){
            return targetSum - root.val == 0;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
