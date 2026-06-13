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
    int max;

    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;

        diameterOfBinaryTreeHelper(root);

        return max;
    }

    public int diameterOfBinaryTreeHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxLeft = diameterOfBinaryTreeHelper(root.left);
        int maxRight = diameterOfBinaryTreeHelper(root.right);

        max = Math.max(max, maxLeft + maxRight);

        return Math.max(maxLeft, maxRight) + 1;
    }
}
