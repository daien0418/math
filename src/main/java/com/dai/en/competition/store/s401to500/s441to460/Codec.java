package com.dai.en.competition.store.s401to500.s441to460;

import java.util.LinkedList;
import java.util.Queue;

import com.dai.en.competition.structure.TreeNode;

public class Codec {

	public String serialize(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		StringBuilder stringBuilder = new StringBuilder();
		if (root != null)
			queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode popNode = queue.poll();
			stringBuilder.append(popNode.val + ",");
			if (popNode.left != null) {
				queue.offer(popNode.left);
			}
			if (popNode.right != null) {
				queue.offer(popNode.right);
			}
		}
		return stringBuilder.toString();
	}

	public TreeNode deserialize(String data) {
		if (data.equals("")) {
			return null;
		}
		String[] strings = data.split(",");
		int index = 0;
		TreeNode root = new TreeNode(Integer.valueOf(strings[index]));
		while (++index < strings.length) {
			insert(root, Integer.valueOf(strings[index]));
		}
		return root;
	}

	private void insert(TreeNode root, int val) {

		while (root != null) {
			if (root.val > val) {
				if (root.left == null) {
					root.left = new TreeNode(val);
					return;
				} else {
					root = root.left;
				}
			} else {
				if (root.right == null) {
					root.right = new TreeNode(val);
					return;
				} else {
					root = root.right;
				}
			}
		}

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
