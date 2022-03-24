package March_2022;

import java.util.ArrayList;
import java.util.List;

public class postorderTraversal_145 {
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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    public void postorder(TreeNode node, List<Integer> list){
        if(node == null)
            return;
        postorder(node.left, list);
        postorder(node.right, list);
        list.add(node.val);
    }
}
