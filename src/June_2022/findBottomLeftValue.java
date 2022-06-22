package June_2022;



public class findBottomLeftValue {
    int val = 0;
    int curHeight = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return val;
    }

    public void dfs(TreeNode root, int height){
        if(root == null)
            return;
        height++;
        dfs(root.left, height);
        dfs(root.right, height);
        if(height > curHeight){
            curHeight = height;
            val = root.val;
        }
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
