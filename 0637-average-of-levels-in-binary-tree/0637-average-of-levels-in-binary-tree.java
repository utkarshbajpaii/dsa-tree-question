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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        
        Queue<TreeNode> q=new LinkedList<>();
       
        q.offer(root);
        while(!q.isEmpty()){
            int level=q.size();
             double avg=0;
            for(int i=0;i<level;i++){
                TreeNode currNode=q.poll();
                avg+=currNode.val;
                if(currNode.left!=null){
                    q.offer(currNode.left);
                }
                if(currNode.right!=null){
                    q.offer(currNode.right);
                }
            }
            avg=avg/level;
            list.add(avg);
        }
        return list;
    }
}