package competition.store.s201to300.s221to240;

import java.util.ArrayList;
import java.util.List;

import competition.structure.TreeNode;

public class LowestCommonAncestor236 {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		List<TreeNode> leftNodes = new ArrayList<TreeNode>();
		List<TreeNode> rightNodes = new ArrayList<TreeNode>();

		dfs(root, p, leftNodes);
		dfs(root, q, rightNodes);

		int minSize = Math.min(leftNodes.size(), rightNodes.size());
		TreeNode resultNode = null;
		for (int i = 0; i < minSize; i++) {
			if (leftNodes.get(i) == null || rightNodes.get(i) == null)
				break;
			if (leftNodes.get(i).val != rightNodes.get(i).val)
				break;
			resultNode = leftNodes.get(i);
		}

		return resultNode;
	}

	public boolean dfs(TreeNode root, TreeNode temp, List<TreeNode> list) {
		if (root == null)
			return false;
		list.add(root);
		if (root.val == temp.val) {
			return true;
		}
		if (dfs(root.left, temp, list) || dfs(root.right, temp, list)) {
			return true;
		}
		list.remove(root);
		return false;
	}

	public static void main(String[] args) {
		LowestCommonAncestor236 lowestCommonAncestor236 = new LowestCommonAncestor236();
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);

		TreeNode result = lowestCommonAncestor236.lowestCommonAncestor(root, new TreeNode(3), new TreeNode(2));

		System.out.println(result.val);
//		List<TreeNode> list = new ArrayList<TreeNode>();
//		lowestCommonAncestor236.dfs(root, new TreeNode(7), list);
//
//		for (TreeNode node : list) {
//			System.out.println(node.val);
//		}
	}

}
