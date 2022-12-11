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
    public StringBuilder serializedResult = new StringBuilder();
    public int index = 0;
    
    public void dfs(TreeNode root) {
        if(root != null) {
            this.serializedResult.append(Integer.toString(root.val) + ",");
            dfs(root.left);
            dfs(root.right);
        } else {
            this.serializedResult.append("null,");
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfs(root);
        return this.serializedResult.toString();
    }
    
    public TreeNode rdeserialize(List<String> nodes) {
        if(nodes.get(0).equals("null")) {
            nodes.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes.get(0)));
        nodes.remove(0);
        root.left = rdeserialize(nodes);
        root.right = rdeserialize(nodes);
        
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return rdeserialize(nodes);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));