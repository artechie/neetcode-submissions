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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(" ");

        while (!dq.isEmpty()) {
            TreeNode rem = dq.poll();

            if (rem.left != null) {
                sb.append(rem.left.val).append(" ");
                dq.add(rem.left);
            } else {
                sb.append("N").append(" ");
            }

            if (rem.right != null) {
                sb.append(rem.right.val).append(" ");
                dq.add(rem.right);
            } else {
                sb.append("N").append(" ");
            }
        }
        return sb.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }

        String[] s = data.split(" ");

        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);
        int i = 1;

        while (!dq.isEmpty()) {
            TreeNode rem = dq.poll();

            if (!s[i].equals("N")) {
                rem.left = new TreeNode(Integer.parseInt(s[i]));
                dq.add(rem.left);
            }
            i++;

            if (!s[i].equals("N")) {
                rem.right = new TreeNode(Integer.parseInt(s[i]));
                dq.add(rem.right);
            }
            i++;
        }
        return root;
    }
}
