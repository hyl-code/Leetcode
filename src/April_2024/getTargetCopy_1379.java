package April_2024;

/*
    给你两棵二叉树，原始树 original 和克隆树 cloned，以及一个位于原始树 original 中的目标节点 target.
    其中，克隆树 cloned 是原始树 original 的一个副本.
    请找出在树 cloned 中，与 target 相同的节点，并返回对该节点的引用（在 C/C++ 等有指针的语言中返回节点指针，其他语言返回节点本身）.
    注意：你不能对两棵二叉树，以及 target 节点进行更改. 只能返回对克隆树 cloned 中已有的节点的引用. 
 */
public class getTargetCopy_1379 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) {
            return null;
        }
        if (original == target) {
            return cloned;
        }
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if (left != null) {
            return left;
        }
        return getTargetCopy(original.right, cloned.right, target);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
