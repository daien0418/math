package competition.store.s501to600.s581to600;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import competition.structure.Node;

public class Postorder {

	public List<Integer> postorder(Node root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<Node> stack = new Stack<Node>();
		if (root != null)
			stack.push(root);
		while (!stack.isEmpty()) {
			Node popNode = stack.pop();
			if (popNode.children == null)
				list.add(popNode.val);
			else {
				List<Node> nodes = popNode.children;
				stack.push(popNode);
				int size = nodes.size();
				for (int i = size - 1; i >= 0; i--) {
					stack.push(nodes.get(i));
				}
				popNode.children = null;
			}
		}

		return list;
	}

	public static void main(String[] args) {

	}

}
