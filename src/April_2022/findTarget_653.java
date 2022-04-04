package April_2022;
import java.util.HashSet;

/*
    给定一个二叉搜索树 root 和一个目标结果 k, 如果 BST 中存在两个元素且它们的和等于给定的目标结果, 则返回 true .
 */

public class findTarget_653 {
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

    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<Integer>();
        return preorder(root, k, set);
    }

    public boolean preorder(TreeNode node, int k, HashSet<Integer> set){
        if(node == null)
            return false;
        if(set.contains(k - node.val)){
            return true;
        }
        set.add(node.val);
        return preorder(node.left, k, set) || preorder(node.right, k, set);

    }
}
