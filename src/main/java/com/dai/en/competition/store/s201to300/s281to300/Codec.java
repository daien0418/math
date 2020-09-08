package com.dai.en.competition.store.s201to300.s281to300;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

import com.dai.en.competition.structure.TreeNode;

public class Codec implements Serializable {

	private static final long serialVersionUID = 1L;

	public String serialize(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		StringBuilder result = new StringBuilder();
		if (root != null)
			queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode popNode = queue.poll();
			if (popNode != null) {
				result.append(popNode.val + ",");
				queue.offer(popNode.left);
				queue.offer(popNode.right);
			} else {
				result.append("null,");
			}
		}

		return result.toString();
	}

	public TreeNode deserialize(String data) {
		if (data.equals(""))
			return null;
		String[] nodes = data.split(",");
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		int index = 0;
		TreeNode root = new TreeNode(Integer.valueOf(nodes[index]));
		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode popNode = queue.poll();
			popNode.left = nodes[++index].equals("null") ? null : new TreeNode(Integer.valueOf(nodes[index]));
			popNode.right = nodes[++index].equals("null") ? null : new TreeNode(Integer.valueOf(nodes[index]));
			if (popNode.left != null)
				queue.offer(popNode.left);
			if (popNode.right != null)
				queue.offer(popNode.right);
		}

		return root;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);

		Codec codec = new Codec();
		String result = codec.serialize(root);
		System.out.println(result);
		TreeNode retRoot = codec.deserialize(result);
		System.out.println(retRoot.val);
	}

}
