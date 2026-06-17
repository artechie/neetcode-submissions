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
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        Set<TreeNode> vis = new HashSet<>();

        while (!stack.isEmpty() && k >= 1) {
            TreeNode top = stack.peek();

            if (!vis.contains(top) && top.left != null) {
                vis.add(top);
                stack.push(top.left);
                continue;
            }

            TreeNode rem = stack.pop();

            if (k-- == 1) {
                return rem.val;
            }

            if (rem.right != null) {
                stack.push(rem.right);
            }
        }
        return -1;
    }
}
