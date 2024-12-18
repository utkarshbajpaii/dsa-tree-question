/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
       if(root==null){
           return 0;
       } 
      if(root.left!=null&&root.right!=null){
        int left=minDepth(root.left);
        int right=minDepth(root.right);
        return 1+Math.min(left,right);
      }else {
         int left=minDepth(root.left);
        int right=minDepth(root.right);
        return 1+Math.max(left,right);
      }
    //   return 0;
    }
}