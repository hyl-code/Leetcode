package December_2023;

/*
    给你一棵完美二叉树的根节点 root, 请你反转这棵树中每个奇数层的节点值.
        例如, 假设第 3 层的节点值是 [2,1,3,4,7,11,29,18], 那么反转后它应该变成 [18,29,11,7,4,3,1,2].
    反转后, 返回树的根节点.
    完美二叉树需满足：二叉树的所有父节点都有两个子节点, 且所有叶子节点都在同一层.
    节点的层数等于该节点到根节点之间的边数.
 */
public class reverseOddLevels_2415 {
    // DFS
    public TreeNode reverseOddLevels(TreeNode root) {
        dfs(root.left, root.right, true);
        return root;
    }

    private void dfs(TreeNode root1, TreeNode root2, boolean isOdd){
        if(root1 == null){
            return;
        }
        if(isOdd){
            int tmp = root1.val;
            root1.val = root2.val;
            root2.val = tmp;
        }
        dfs(root1.left, root2.right, !isOdd);
        dfs(root1.right, root2.left, !isOdd);
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
