package May_2022;

import java.util.ArrayList;
import java.util.List;

public class getAllElements_1305 {
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

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> nums1 = new ArrayList<>();
        List<Integer> nums2 = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        inorder(root1, nums1);
        inorder(root2, nums2);
        int i = 0, j = 0;
        while(true){
            if(i == nums1.size()){
                res.addAll(nums2.subList(j, nums2.size()));
                break;
            }
            if(j == nums2.size()){
                res.addAll(nums1.subList(i, nums1.size()));
                break;
            }
            if(nums1.get(i) < nums2.get(j)){
                res.add(nums1.get(i));
                i++;
            }else{
                res.add(nums2.get(j));
                j++;
            }
        }
        return res;
    }

    public void inorder(TreeNode root, List<Integer> nums){
        if(root != null){
            inorder(root.left, nums);
            nums.add(root.val);
            inorder(root.right, nums);
        }
    }
}
