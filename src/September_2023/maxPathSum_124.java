package September_2023;

/*
    二叉树中的路径被定义为一条节点序列, 序列中每对相邻节点之间都存在一条边.
    同一个节点在一条路径序列中至多出现一次.
    该路径至少包含一个节点, 且不一定经过根节点.
    路径和是路径中各节点值的总和.
    给你一个二叉树的根节点 root, 返回其最大路径和.
 */
public class maxPathSum_124 {
    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftVal = dfs(node.left);       // 左子树最大链和
        int rightVal = dfs(node.right);     // 右子树最大链和
        res = Math.max(res, leftVal + rightVal + node.val); // 两条链拼成路径
        return Math.max(Math.max(leftVal, rightVal) + node.val, 0); //当前子树最大链和
    }

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
}
