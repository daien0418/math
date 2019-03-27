package competition.store.s901to1000.s961to980;

import java.util.LinkedList;
import java.util.Queue;

import competition.structure.TreeNode;

public class IsUnivalTree {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null)
            return true;

        int value = root.val;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val != value) {
                return false;
            }

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }

}
