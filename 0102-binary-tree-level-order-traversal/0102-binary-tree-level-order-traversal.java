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
    public List<List<Integer>> levelOrder(TreeNode root) {
       Queue<TreeNode> q=new LinkedList<>();
       List<List<Integer>> list=new ArrayList<>();
       if(root==null){
        return new ArrayList<>();
       }
       q.add(root);
       while(!q.isEmpty()){
        int level=q.size();
        List<Integer> l=new ArrayList<>();
        for(int i=0;i<level;i++){
            TreeNode curr=q.poll();
            if(curr.left!=null){
                q.add(curr.left);
            }
            if(curr.right!=null){
                q.add(curr.right);
            }
            l.add(curr.val);
        }
        list.add(l);
       }
       return list;
    }
}