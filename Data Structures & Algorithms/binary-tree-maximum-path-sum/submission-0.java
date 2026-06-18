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
    private static final int MIN = -1001;
    
    private int max; 

    public int maxPathSum(TreeNode root) {
        max = MIN;

        solve(root);

        return max;
    }

    private int solve(TreeNode root) {
        if (root == null) {
            return MIN;
        }

        int left = solve(root.left);
        int right = solve(root.right);

        int maxLeft = Math.max(left, 0);
        int maxRight = Math.max(right, 0);

        max = Math.max(max, root.val + maxLeft + maxRight);

        return root.val + Math.max(maxLeft, maxRight);
    }
}
