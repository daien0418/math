package competition.store.s501to600.s561to580;

import competition.structure.TreeNode;

public class FindTilt {

	int til = 0;

	public int findTilt(TreeNode root) {
		sum(root);
		return til;
	}

	private int sum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftSum = sum(root.left);
		int rightSum = sum(root.right);

		til = til + Math.abs(leftSum - rightSum);

		return root.val + leftSum + rightSum;
	}

	public static void main(String[] args) {
		FindTilt findTilt = new FindTilt();
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);

		System.out.println(findTilt.findTilt(root));
	}

}
