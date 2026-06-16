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
    int kVal;

    public int kthSmallest(TreeNode root, int k) {
        kVal = k;

        return solve(root);
    }

    private int solve(TreeNode root) {
        int left = -1;
        
        if (root.left != null) {
            left = solve(root.left);
        }

        if (left != -1) {
            return left;
        }

        if (kVal-- == 1) {
            return root.val;
        }

        if (root.right != null) {
            return solve(root.right);
        }

        return -1;
    }
}
