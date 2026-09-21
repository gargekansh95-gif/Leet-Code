import java.util.LinkedList;
import java.util.Queue;

class CBTInserter {
    private TreeNode root;
    private Queue<TreeNode> deque;

    public CBTInserter(TreeNode root) {
        this.root = root;
        this.deque = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);


        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null || node.right == null) {
                deque.offer(node);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }
    
    public int insert(int val) {
        TreeNode child = new TreeNode(val);
        TreeNode parent = deque.peek();
        
        if (parent.left == null) {
            parent.left = child;
        } else {
            parent.right = child;

            deque.poll();
        }
        
        
        deque.offer(child);
        return parent.val;
    }
    
    public TreeNode get_root() {
        return this.root;
    }
}
