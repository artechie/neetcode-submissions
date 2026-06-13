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

        if (root == null) {
            return ans;
        }

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);

        while (!dq.isEmpty()) {
            int size = dq.size();
            
            ans.add(dq.peek().val);

            while (size-- > 0) {
                TreeNode rem = dq.remove();
                
                if (rem.right != null) {
                    dq.add(rem.right);
                }
                if (rem.left != null) {
                    dq.add(rem.left);
                }
            }
        }
        return ans;
    }
}
