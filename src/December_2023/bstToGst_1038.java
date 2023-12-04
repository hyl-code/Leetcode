package December_2023;

/*
    给定一个二叉搜索树 root (BST), 请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和.
    提醒一下, 二叉搜索树 满足下列约束条件：
        节点的左子树仅包含键小于节点键的节点.
        节点的右子树仅包含键大于节点键的节点.
        左右子树也必须是二叉搜索树.
 */
public class bstToGst_1038 {
    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode node){
        if(node == null){
            return;
        }
        if(node.right != null){
            dfs(node.right);
        }
        sum += node.val;
        node.val = sum;
        if(node.left != null){
            dfs(node.left);
        }
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
