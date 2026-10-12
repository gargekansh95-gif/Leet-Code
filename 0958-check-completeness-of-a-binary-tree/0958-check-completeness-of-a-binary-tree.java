import java.util.*;

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean notNullCheck = false;
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.offer(root);

        while (!q1.isEmpty()) {
            TreeNode node = q1.poll();

            if (node == null) {
                notNullCheck = true;
            } else {
                if (notNullCheck) {
                    return false;
                }

                q1.offer(node.left);
                q1.offer(node.right);
            }
        }

        return true;
    }
}