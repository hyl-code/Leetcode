package July_2022;

/*
    给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先 .

    百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q, 最近公共祖先表示为一个结点 x,
    满足 x 是 p、q 的祖先且 x 的深度尽可能大 (一个节点也可以是它自己的祖先). ”

    例如, 给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5]
 */

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

