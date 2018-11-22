package competition.store.s201to300.s221to240;

import java.util.HashSet;
import java.util.Set;

import competition.structure.TreeNode;

public class LowestCommonAncestor {

	Set<TreeNode> set = new HashSet<TreeNode>();

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode result = null;
		TreeNode temp = root;
		while (temp != null) {
			set.add(temp);
			if (temp.val > p.val) {
				temp = temp.left;
			} else if (temp.val < p.val) {
				temp = temp.right;
			} else {
				break;
			}
		}

		temp = root;
		result = root;
		while (temp != null) {
			if (set.contains(temp)) {
				result = temp;
			}
			if (temp.val > q.val) {
				temp = temp.left;
			} else if (temp.val < q.val) {
				temp = temp.right;
			} else {
				break;
			}
		}

		return result;
	}

	public static void main(String[] args) {

	}

}
