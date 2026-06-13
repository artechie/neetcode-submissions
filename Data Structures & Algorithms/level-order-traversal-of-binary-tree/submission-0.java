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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);
        List<Integer> l;

        while (!dq.isEmpty()) {
            int size = dq.size();
            l = new ArrayList<>();

            while (size-- > 0) {
                TreeNode rem = dq.remove();

                if (rem.left != null) {
                    dq.add(rem.left);
                }
                if (rem.right != null) {
                    dq.add(rem.right);
                }
                l.add(rem.val);
            }
            ans.add(l);
        }
        return ans;
    }
}
