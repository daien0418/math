package competition.store.s601to700.s641to660;

import competition.structure.TreeNode;

public class ConstructMaximumBinaryTree {

	public TreeNode constructMaximumBinaryTree(int[] nums) {
		if (nums == null)
			return null;
		return findMax(nums, 0, nums.length - 1);
	}

	private TreeNode findMax(int[] nums, int low, int high) {
		if (low > high)
			return null;
		int index = low;

		for (int i = low; i <= high; i++) {
			if (nums[i] > nums[index]) {
				index = i;
			}
		}

		TreeNode root = new TreeNode(nums[index]);
		root.left = findMax(nums, low, index - 1);
		root.right = findMax(nums, index + 1, high);

		return root;
	}

	public static void main(String[] args) {
		ConstructMaximumBinaryTree constructMaximumBinaryTree = new ConstructMaximumBinaryTree();
		TreeNode root = constructMaximumBinaryTree.constructMaximumBinaryTree(new int[] {3,2,1,6,0,5});
		System.out.println(root);
	}

}
