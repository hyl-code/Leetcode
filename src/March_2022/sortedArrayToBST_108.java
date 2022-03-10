package March_2022;

/*
    给你一个整数数组 nums, 其中元素已经按升序排列, 请你将其转换为一棵高度平衡二叉搜索树 .
    高度平衡 二叉树是一棵满足 「 每个节点的左右两个子树的高度差的绝对值不超过 1 」 的二叉树 .
 */

public class sortedArrayToBST_108 {
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

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null)
            return null;
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int l, int r){
        if(l > r)
            return null;
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, l, mid - 1);
        root.right = build(nums, mid + 1, r);
        return root;
    }
}
