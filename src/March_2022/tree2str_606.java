package March_2022;

/*
    你需要采用前序遍历的方式, 将一个二叉树转换成一个由括号和整数组成的字符串 .
    空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对 .
 */

public class tree2str_606 {
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

    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        create(root, sb);
        return sb.toString();
    }

    public void create(TreeNode root, StringBuilder sb){
        if(root != null){
            sb.append(root.val);
            if(root.left != null || root.right != null){
                sb.append('(');
                create(root.left, sb);
                sb.append(')');
                if(root.right != null){
                    sb.append('(');
                    create(root.right, sb);
                    sb.append(')');
                }
            }
        }
    }
}
