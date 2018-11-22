package competition.store.s401to500.s421to440;

import java.util.ArrayList;
import java.util.List;

import competition.structure.Node;

public class LevelOrder {

	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root == null)
			return list;

		List<Node> nodeList = new ArrayList<Node>();
		nodeList.add(root);

		while (nodeList.size() > 0) {
			List<Integer> newList = new ArrayList<Integer>();
			List<Node> newNodeList = new ArrayList<Node>();
			for (Node node : nodeList) {
				newList.add(node.val);
				newNodeList.addAll(node.children);
			}
			list.add(newList);
			nodeList.clear();
			nodeList = newNodeList;
		}

		return list;
	}

	public static void main(String[] args) {

	}

}
