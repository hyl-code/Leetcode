package April_2023;

/*
    给定二叉树的根节点 root, 找出存在于不同节点 A 和 B 之间的最大值 V, 其中 V = |A.val - B.val|, 且 A 是 B 的祖先.
    (如果 A 的任何子节点之一为 B, 或者 A 的任何子节点是 B 的祖先, 那么我们认为 A 是 B 的祖先)
 */
public class maxAncestorDiff_1026 {
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

    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    public int dfs(TreeNode node, int max, int min){
        if(node == null){
            return 0;
        }
        //根据左右节点依次延伸, 保护最大最小值
        max = Math.max(max, node.val);
        min = Math.min(min, node.val);
        if(node.left == null && node.right == null){
            return max - min;
        }
        int left = dfs(node.left, max, min);
        int right = dfs(node.right, max, min);
        return left > right ? left : right;
    }
}




