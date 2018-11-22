package competition.store.s201to300.s221to240;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import competition.structure.TreeNode;

public class KthSmallest {

	public int kthSmallest(TreeNode root, int k) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root != null)
			stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode popNode = stack.pop();
			if (popNode.left == null) {
				list.add(popNode.val);
				if (popNode.right != null) {
					stack.push(popNode.right);
				}
			} else {
				stack.push(popNode);
				stack.push(popNode.left);
				popNode.left = null;
			}
		}

		return list.get(k - 1);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);

		KthSmallest kthSmallest = new KthSmallest();
		System.out.println(kthSmallest.kthSmallest(root, 4));
	}

}
