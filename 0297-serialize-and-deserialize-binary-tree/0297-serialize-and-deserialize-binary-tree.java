/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        Queue<TreeNode> q=new LinkedList<>();
        StringBuilder result=new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node==null){
                result.append("n ");
                continue;
            }
            result.append(node.val+" ");
            q.add(node.left);
            q.add(node.right);
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==""){
            return null;
        }
        Queue<TreeNode> que=new LinkedList<>();
        String[] values=data.split(" ");
        TreeNode root=new TreeNode(Integer.parseInt(values[0]));
        que.add(root);
        for(int i=1;i<values.length;i++){
            TreeNode parent=que.poll();
            if(!values[i].equals("n")){
                TreeNode left=new TreeNode(Integer.parseInt(values[i]));
                parent.left=left;
                que.add(left);
            }
            if(!values[++i].equals("n")){
                TreeNode right=new TreeNode(Integer.parseInt(values[i]));
                parent.right=right;
                que.add(right);

            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));