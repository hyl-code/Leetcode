package September_2023;

import java.util.ArrayList;
import java.util.List;
/*
    给定一个二叉树的根节点 root, 想象自己站在它的右侧, 按照从顶部到底部的顺序, 返回从右侧所能看到的节点值.
 */
public class rightSideView_199 {
    private final List<Integer> list = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return list;
    }

    private void dfs(TreeNode root, int depth){
        if(root == null){
            return;
        }
        if(depth == list.size()){
            list.add(root.val);
        }
        dfs(root.right, depth + 1);
        dfs(root.left, depth + 1);
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
