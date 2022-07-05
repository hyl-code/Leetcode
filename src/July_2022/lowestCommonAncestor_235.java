package July_2022;

public class lowestCommonAncestor_235 {
    //二叉搜索树的特性
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        search(root, p, q);
        return res;
    }

    public void search(TreeNode root, TreeNode p, TreeNode q){
        if((root.val - p.val) * (root.val - q.val) <= 0){
            res = root;
        }else if(root.val < p.val && root.val < q.val){
            search(root.right, p, q);
        }else{
            search(root.left, p, q);
        }
    }
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

