package November_2023;
/*
    给你一棵二叉树, 每个节点的值为 1 到 9. 我们称二叉树中的一条路径是「伪回文」的, 当它满足：路径经过的所有节点值的排列中, 存在一个回文序列.
    请你返回从根到叶子节点的所有路径中伪回文路径的数目.
 */
public class pseudoPalindromicPaths_1457 {
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] counter = new int[10];
        return dfs(root, counter);
    }

    public int dfs(TreeNode root, int[] counter){
        if(root == null){
            return 0;
        }
        counter[root.val]++;
        int res = 0;
        if(root.left == null && root.right == null){
            if(isValid(counter)){
                res = 1;
            }
        }else{
            res = dfs(root.left, counter) + dfs(root.right, counter);
        }
        counter[root.val]--;
        return res;
    }

    public boolean isValid(int[] counter){
        int odd =0;
        for(int value : counter){
            if(value % 2 == 1){
                odd++;
            }
        }
        return odd <= 1;
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
