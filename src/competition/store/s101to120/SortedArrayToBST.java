package competition.store.s101to120;

public class SortedArrayToBST {

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;
		int index = (nums.length - 1) / 2;
		TreeNode root = new TreeNode(nums[index]);
		if (index > 0)
			root.left = generate(nums, 0, index - 1);
		if (index < nums.length - 1)
			root.right = generate(nums, index + 1, nums.length - 1);
		return root;
	}

	private TreeNode generate(int[] nums, int start, int end) {
		int mid = (start + end) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		if(start<mid)
			node.left = generate(nums, start, mid-1);
		if(mid<end)
			node.right =generate(nums, mid+1, end);
		return node;
	}

	public static void main(String[] args) {

	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
