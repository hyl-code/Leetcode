package May_2023;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
    给出二叉树的根节点 root, 树上每个节点都有一个不同的值.
    如果节点值在 to_delete 中出现, 我们就把该节点从树上删去, 最后得到一个森林（一些不相交的树构成的集合）.
    返回森林中的每棵树. 你可以按任意顺序组织答案.
 */
public class delNodes_1110 {
    Set<Integer> set = new HashSet<>();
     List<TreeNode> list = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for(int del : to_delete){
            set.add(del);
        }
        // root 节点特殊情况
        if(!set.contains(root.val)){
            list.add(root);
        }
        dfs(root);
        return list;
    }

    public TreeNode dfs(TreeNode root){
        if(root == null){
            return null;
        }
        //后序遍历
        root.left = dfs(root.left);
        root.right = dfs(root.right);
        if(set.contains(root.val)){
            if(root.left != null){
                list.add(root.left);
            }
            if(root.right != null){
                list.add(root.right);
            }
            root = null;
        }
        return root;
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
