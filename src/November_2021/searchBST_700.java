package November_2021;

/*
    给定二叉搜索树(BST)的根节点和一个值. 你需要在BST中找到节点值等于给定值的节点.
    返回以该节点为根的子树. 如果节点不存在, 则返回 NULL.
*/

public class searchBST_700 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //递归
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val)
            return root;
        return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    //迭代
    public TreeNode searchBST2(TreeNode root, int val) {
        while(root != null && root.val != val){
            root = root.val > val ? root.left : root.right;
        }
        return root;
    }
}
