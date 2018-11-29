package competition.store.s601to700.s621to640;

import java.util.Stack;

import competition.structure.TreeNode;

public class AddOneRow {

	public TreeNode addOneRow(TreeNode root, int v, int d) {
		if (d == 1) {
			TreeNode node = new TreeNode(v);
			node.left = root;
			root = node;
		} else {
			Stack<TreeNode> inStack = new Stack<TreeNode>();
			Stack<TreeNode> outStack = new Stack<TreeNode>();
			inStack.push(root);
			int deep = 1;
			while (!inStack.isEmpty()) {
				if (deep++ == d - 1) {
					break;
				}
				while (!inStack.isEmpty()) {
					TreeNode popNode = inStack.pop();
					if (popNode.left != null)
						outStack.push(popNode.left);
					if (popNode.right != null)
						outStack.push(popNode.right);
				}
				while (!outStack.isEmpty()) {
					inStack.push(outStack.pop());
				}

			}

			while (!inStack.isEmpty()) {
				TreeNode node = inStack.pop();
				TreeNode tempLeft = node.left;
				TreeNode tempRight = node.right;
				node.left = new TreeNode(v);
				node.right = new TreeNode(v);
				node.left.left = tempLeft;
				node.right.right = tempRight;
			}
		}

		return root;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(1);

		AddOneRow addOneRow = new AddOneRow();
		TreeNode newRoot = addOneRow.addOneRow(root, 1, 3);
		System.out.println(newRoot);
	}

}
