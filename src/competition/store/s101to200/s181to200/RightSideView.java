package competition.store.s101to200.s181to200;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import competition.structure.TreeNode;

public class RightSideView {

	Stack<TreeNode> inSet = new Stack<TreeNode>();
	Stack<TreeNode> outSet = new Stack<TreeNode>();

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root != null)
			outSet.push(root);

		while (!outSet.isEmpty()) {
			list.add(outSet.peek().val);
			while (!outSet.isEmpty()) {
				TreeNode popNode = outSet.pop();
				if (popNode.right != null) {
					inSet.push(popNode.right);
				}
				if (popNode.left != null) {
					inSet.push(popNode.left);
				}
			}
			while (!inSet.isEmpty()) {
				outSet.push(inSet.pop());
			}
		}

		return list;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);

		RightSideView rightSideView = new RightSideView();
		List<Integer> list = rightSideView.rightSideView(root);
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}

}
