package competition.store.s601to700.s641to660;

import java.util.ArrayList;
import java.util.List;

import competition.structure.TreeNode;

public class PrintTree {

	public List<List<String>> printTree(TreeNode root) {
		List<List<String>> list = new ArrayList<List<String>>();

		int deep = deep(root);
		int m = deep;
		int n = col(deep);

		for (int i = 0; i < m; i++) {
			List<String> newList = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				newList.add("");
			}
			list.add(newList);
		}

		generate(root, 0, n - 1, 0, list);

		return list;
	}

	private void generate(TreeNode root, int start, int end, int index, List<List<String>> list) {
		int valIndex = (start + end) / 2;
		List<String> subList = list.get(index);
		subList.set(valIndex, String.valueOf(root.val));
		if (root.left != null) {
			generate(root.left, start, valIndex - 1, index + 1, list);
		}
		if (root.right != null) {
			generate(root.right, valIndex + 1, end, index + 1, list);
		}
	}

	private int col(int c) {
		if (c == 1)
			return 1;
		return 2 * col(c - 1) + 1;
	}

	private int deep(TreeNode root) {
		if (root == null)
			return 0;
		int leftDeep = deep(root.left);
		int rightDeep = deep(root.right);

		return 1 + Math.max(leftDeep, rightDeep);
	}

	public static void main(String[] args) {

	}

}
