package August_2023;

/*
    给你一棵根为 root 的二叉树, 请你返回二叉树中好节点的数目.
    「好节点」X 定义为：从根到该节点 X 所经过的节点中, 没有任何节点的值大于 X 的值.
 */
public class goodNodes_1448 {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    public int dfs(TreeNode root, int max){
        if(root == null){
            return 0;
        }
        int res = 0;
        if(root.val >= max){
            res++;
            max = root.val;
        }
        res += dfs(root.left, max);
        res += dfs(root.right, max);
        return res;
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
