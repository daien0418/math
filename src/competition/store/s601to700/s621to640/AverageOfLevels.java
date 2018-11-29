package competition.store.s601to700.s621to640;

import java.util.ArrayList;
import java.util.List;

import competition.structure.TreeNode;

public class AverageOfLevels {

	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> list = new ArrayList<Double>();
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		List<TreeNode> nodesTemp = new ArrayList<TreeNode>();
		if (root != null)
			nodes.add(root);
		while (nodes.size() > 0) {
			int sum = 0;
			long val = 0;
			for (TreeNode node : nodes) {
				if (node.left != null)
					nodesTemp.add(node.left);
				if (node.right != null)
					nodesTemp.add(node.right);
				val += node.val;
				sum++;
			}
			list.add(val * 1d / sum);
			nodes.clear();
			nodes.addAll(nodesTemp);
			nodesTemp.clear();
		}

		return list;
	}

	public static void main(String[] args) {

	}

}
