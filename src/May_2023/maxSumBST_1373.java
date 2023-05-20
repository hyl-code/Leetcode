package May_2023;

/*
    给你一棵以 root 为根的二叉树, 请你返回任意二叉搜索子树的最大键值和.
    二叉搜索树的定义如下：
        任意节点的左子树中的键值都小于此节点的键值.
        任意节点的右子树中的键值都大于此节点的键值.
        任意节点的左子树和右子树都是二叉搜索树.
 */
public class maxSumBST_1373 {
    private int res = 0;
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return res;
    }

    public int[] dfs(TreeNode node){
        //每棵子树返回：这颗子树的最小节点值、最大节点值、所有节点值之和
        if(node == null){
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int val = node.val;
        if(val <= left[1] || val >= right[0]){
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        }
        int sum = left[2] + right[2] + val;
        res = Math.max(res, sum);
        return new int[]{Math.min(left[0], val), Math.max(right[1], val), sum};
    }

    public static class TreeNode {
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
