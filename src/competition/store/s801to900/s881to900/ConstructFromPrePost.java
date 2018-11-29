package competition.store.s801to900.s881to900;

import competition.structure.TreeNode;

public class ConstructFromPrePost {

	public TreeNode constructFromPrePost(int[] pre, int[] post) {
		if (pre == null || post == null)
			return null;
		return generate(pre, post, 0, 0, post.length - 1);
	}

	private TreeNode generate(int[] pre, int[] post, int preLow, int postLow, int postHigh) {
		if (preLow >= pre.length || postLow > postHigh)
			return null;
		TreeNode root = new TreeNode(pre[preLow]);
		int index = findIndex(post, pre[preLow]);
		if (index <= postLow)
			return root;
		int index2 = findIndex(post, pre[preLow + 1]);
		root.left = generate(pre, post, preLow + 1, postLow, index2);
		root.right = generate(pre, post, preLow + 1 + index2 - postLow + 1, index2 + 1, index - 1);

		return root;
	}

	private int findIndex(int[] post, int val) {
		for (int i = 0; i < post.length; i++) {
			if (post[i] == val) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		ConstructFromPrePost constructFromPrePost = new ConstructFromPrePost();
		TreeNode root = constructFromPrePost.constructFromPrePost(new int[] { 1, 2, 4, 5, 3, 6, 7 },
				new int[] { 4, 5, 2, 6, 7, 3, 1 });
		System.out.println(root);
	}

}
