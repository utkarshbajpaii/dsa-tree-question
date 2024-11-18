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
    public int sumOfLeftLeaves(TreeNode root) {
        return solve(root,false);
    }
    public int solve(TreeNode root,boolean isLeft){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null&&isLeft==true){
            return root.val;
        }
        return solve(root.left,true)+solve(root.right,false);
    }
}