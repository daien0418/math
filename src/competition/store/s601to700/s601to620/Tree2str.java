package competition.store.s601to700.s601to620;

import competition.structure.TreeNode;

public class Tree2str {

	public String tree2str(TreeNode t) {
		if (t == null)
			return "";
		return treetostring(t);
	}

	private String treetostring(TreeNode t) {
		if (t == null)
			return "()";
		String leftS = treetostring(t.left);
		String rightS = treetostring(t.right);

		if (leftS.equals("()")) {
			if (rightS.equals("()")) {
				return t.val + "";
			} else {
				return t.val + "()" + "(" + rightS + ")";
			}
		} else {
			if (rightS.equals("()")) {
				return t.val + "(" + leftS + ")";
			} else {
				return t.val + "(" + leftS + ")" + "(" + rightS + ")";
			}
		}
	}

	public static void main(String[] args) {

	}

}
