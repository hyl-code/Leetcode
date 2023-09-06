package September_2023;

/*
     root 的二叉树, 返回它最深的叶节点的最近公共祖先.
 */
public class lcaDeepestLeaves_1123 {
    private TreeNode resNode;
    private int maxDepth = -1;      // 全局最大深度

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        return resNode;
    }

    // DFS
    private int dfs(TreeNode node, int depth){
        if(node == null){
            maxDepth = Math.max(maxDepth, depth);       // 维护全局最大深度
            return depth;
        }
        int leftMaxDepth = dfs(node.left, depth + 1);
        int rightMaxDepth = dfs(node.right, depth + 1);
        // leftMaxDepth = rightMaxDepth = maxDepth 时, 则更新节点
        if(leftMaxDepth == rightMaxDepth && leftMaxDepth == maxDepth){
            resNode = node;
        }
        return Math.max(leftMaxDepth, rightMaxDepth);
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
