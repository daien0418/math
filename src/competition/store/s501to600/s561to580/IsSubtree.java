package competition.store.s501to600.s561to580;

import competition.structure.TreeNode;

public class IsSubtree {

	public boolean isSubtree(TreeNode s, TreeNode t) {

		if (s == null)
			return false;

		return isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
	}

	private boolean isSame(TreeNode s, TreeNode t) {
		if (s == null && t == null)
			return true;
		if ((s == null && t != null) || (s != null && t == null))
			return false;

		return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
	}

	public static void main(String[] args) {

	}

}
