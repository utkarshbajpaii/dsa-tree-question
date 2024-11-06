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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(inorder,0,inorder.length-1,postorder,0,postorder.length-1,map);
    }
    public TreeNode build(int[] inorder,int inStart,int inEnd,int[] preorder,int preStart,int preEnd,Map<Integer,Integer> map){
        if(inStart>inEnd||preStart>preEnd){
            return null;
        }
        TreeNode node=new TreeNode(preorder[preEnd]);
        int inRoot=map.get(preorder[preEnd]);
        int numLeft=inRoot-inStart;
        node.left=build(inorder,inStart,inRoot-1,preorder,preStart,preStart+numLeft-1,map);
        node.right=build(inorder,inRoot+1,inEnd,preorder,preStart+numLeft,preEnd-1,map);
        return node;
    }
}