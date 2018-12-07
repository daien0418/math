package competition.store.s901to1000.s921to940;

import competition.structure.TreeNode;

public class RangeSumBST {

	public int rangeSumBST(TreeNode root, int L, int R) {
		int sum = 0;

		return sum;
	}

	private int cal(TreeNode root, int L, int R) {
		if (root == null)
			return 0;
		if (root.val >= L && root.val <= R)
			return root.val + cal(root.left, L, R) + cal(root.right, L, R);
		if (root.val < L)
			return cal(root.right, L, R);
		return cal(root.left, L, R);
	}

	public static void main(String[] args) {

	}

}
