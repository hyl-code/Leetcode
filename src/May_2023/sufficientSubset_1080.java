package May_2023;

/*
    给你二叉树的根节点 root 和一个整数 limit, 请你同时删除树中所有不足节点, 并返回最终二叉树的根节点.
    假如通过节点 node 的每种可能的 "根-叶" 路径上值的总和全都小于给定的 limit, 则该节点被称之为不足节点, 需要被删除.
    叶子节点, 就是没有子节点的节点.
 */

public class sufficientSubset_1080 {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if(root == null){
            return null;
        }
        // root 子节点时直接返回 root
        if(root.left == null && root.right == null){
            return root.val >= limit ? root : null;
        }
        root.left = sufficientSubset(root.left, limit - root.val);
        root.right = sufficientSubset(root.right, limit - root.val);
        // 若叶子结点都被删掉了, 则说明该节点为不足节点, 所以返回 null.
        return root.left == null && root.right == null ? null : root;
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
