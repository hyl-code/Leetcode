package April_2022;

/*
    给你一个二叉树的根节点 root, 判断其是否是一个有效的二叉搜索树 .
    有效 二叉搜索树定义如下 :
        节点的左子树只包含 小于 当前节点的数 .
        节点的右子树只包含 大于 当前节点的数 .
        所有左子树和右子树自身必须也是二叉搜索树 .
 */

public class isValidBST_98 {
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

    public boolean isValidBST(TreeNode root) {
        return judge(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean judge(TreeNode node, long min, long max){
        if(node == null)
            return true;
        if(node.val <= min || node.val >= max){
            return false;
        }
        return judge(node.left, min, node.val) && judge(node.right, node.val, max);
    }
}
