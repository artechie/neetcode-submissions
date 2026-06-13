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
    private boolean isBalanced;

    public boolean isBalanced(TreeNode root) {
        isBalanced = true;

        solve(root);

        return isBalanced;
    }

    private int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxLeft = solve(root.left);
        int maxRight = solve(root.right);

        if (Math.abs(maxLeft - maxRight) > 1) {
            isBalanced = false;
        }

        return Math.max(maxLeft, maxRight) + 1;
    }
}
