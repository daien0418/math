package competition.store.q81to100;

import java.util.ArrayList;
import java.util.List;

import competition.structure.TreeNode;

public class GenerateTrees {

	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> list = null;
		list = subNode(1, n);
		return list;
	}

	/**
	 * 当n=18时候，时间太久，然后结果却通过了。。。。
	 *
	 * @param start
	 * @param end
	 * @return
	 */
	private List<TreeNode> subNode(int start, int end) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		if (start > end) {
			list.add(null);
			return list;
		}
		if (start == end) {
			list.add(new TreeNode(start));
			return list;
		}

		for (int i = start; i <= end; i++) {
			List<TreeNode> leftRoots = subNode(start, i - 1);
			List<TreeNode> rightRoots = subNode(i + 1, end);
			for (int j = 0; j < leftRoots.size(); j++) {
				for (int k = 0; k < rightRoots.size(); k++) {
					TreeNode root = new TreeNode(i);
					root.left = leftRoots.get(j);
					root.right = rightRoots.get(k);
					list.add(root);
				}
			}
		}

		return list;
	}

//	private TreeNode reverse(int sum, TreeNode root) {
//		if (root == null)
//			return null;
//		TreeNode newRoot = new TreeNode(sum - root.val);
//		newRoot.right = reverse(sum, root.left);
//		newRoot.left = reverse(sum, root.right);
//		return newRoot;
//	}

	public static void main(String[] args) {
		GenerateTrees generateTrees = new GenerateTrees();
		generateTrees.generateTrees(18);
	}

}
