package com.dai.en.competition.store.s101to200.s101to120;

import com.dai.en.competition.structure.TreeNode;

public class BuildTree2 {

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder==null||inorder.length==0) return null;
		int head = 0;
		int tail = postorder.length - 1;
		TreeNode root = new TreeNode(postorder[tail]);
		int index = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == postorder[tail]) {
				index = i;
				break;
			}
		}

		if (index > head)
			root.left = generate(head, index - 1, head, head + index - head - 1, inorder, postorder);
		if (index < tail)
			root.right = generate(index + 1, tail, head + index - head, tail - 1, inorder, postorder);
		return root;
	}

	private TreeNode generate(int is, int ie, int ps, int pe, int[] inorder, int[] postorder) {
		TreeNode root = new TreeNode(postorder[pe]);
		int index = is;
		for (int i = is; i <= ie; i++) {
			if (inorder[i] == postorder[pe]) {
				index = i;
				break;
			}
		}

		if (index > is)
			root.left = generate(is, index - 1, ps, ps + index - is - 1, inorder, postorder);
		if (index < ie)
			root.right = generate(index + 1, ie, ps + index - is, pe - 1, inorder, postorder);
		return root;
	}

	public static void main(String[] args) {
		int[] inorder = new int[] { 9, 3, 15, 20, 7 };
		int[] postorder = new int[] { 9, 15, 7, 20, 3 };
		BuildTree2 buildTree2 = new BuildTree2();
		TreeNode root = buildTree2.buildTree(inorder, postorder);
		System.out.println(root);
	}

}
