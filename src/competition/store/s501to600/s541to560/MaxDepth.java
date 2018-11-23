package competition.store.s501to600.s541to560;

import competition.structure.Node;

public class MaxDepth {

	public int maxDepth(Node root) {
		if (root == null)
			return 0;
		int subSum = 0;
		for (Node subNode : root.children) {
			int subDep = maxDepth(subNode);
			if (subDep > subSum) {
				subSum = subDep;
			}
		}

		return 1 + subSum;
	}

	public static void main(String[] args) {

	}

}
