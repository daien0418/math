package competition.store.s101to200.s101to120;

import competition.structure.TreeLinkNode;

public class Connect {

	public void connect(TreeLinkNode root) {
		if (root != null) {
			subConnect(root.left, root.right, root.next);
		}
	}

	/**
	 * ตÝน้
	 *
	 * @param left
	 * @param right
	 * @param uncle
	 */
	private void subConnect(TreeLinkNode left, TreeLinkNode right, TreeLinkNode uncle) {
		if (left == null)
			return;
		left.next = right;
		right.next = uncle != null ? uncle.left : null;
		if (left.left == null)
			return;
		subConnect(left.left, left.right, right);
		subConnect(right.left, right.right, right.next);
	}

	public static void main(String[] args) {

	}

}
