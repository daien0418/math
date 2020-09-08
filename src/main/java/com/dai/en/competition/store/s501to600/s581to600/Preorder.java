package com.dai.en.competition.store.s501to600.s581to600;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.dai.en.competition.structure.Node;

public class Preorder {

	public List<Integer> preorder(Node root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<Node> stack = new Stack<Node>();
		if (root != null)
			stack.push(root);
		while (!stack.isEmpty()) {
			Node popNode = stack.pop();
			list.add(popNode.val);
			if (popNode.children != null) {
				List<Node> children = popNode.children;
				int size = children.size();
				for (int i = size - 1; i >= 0; i--) {
					stack.push(children.get(i));
				}
			}
		}

		return list;
	}

	public static void main(String[] args) {

	}

}
