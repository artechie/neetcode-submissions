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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        solve(root, 1, ans);

        return ans;
    }

    private void solve(TreeNode root, int ht, List<Integer> ans) {
        if (root == null) {
            return;
        }
        
        if (ans.size() < ht) {
            ans.add(root.val);
        }

        solve(root.right, ht + 1, ans);
        solve(root.left, ht + 1, ans);
    }
}
