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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return solve(preorder, inorder, 0, inorder.length - 1, 0, inorder.length - 1, map);
    }

    private TreeNode solve(int[] pre, int[] in, int ps, int pe, int ins, int ine, Map<Integer, Integer> map) {
        if (ps > pe || ins > ine) {
            return null;
        }

        TreeNode root = new TreeNode(pre[ps]);
        int idx = map.get(pre[ps]);
        int len = idx - ins;

        root.left = solve(pre, in, ps + 1, ps + len, ins, idx - 1, map);
        root.right = solve(pre, in, ps + len + 1, pe, idx + 1, ine, map);

        return root;
    }
}
