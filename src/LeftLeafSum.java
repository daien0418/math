public class LeftLeafSum {

	private int sum = 0;

	public void count(MNode parent, MNode node) {
		if (node.left != null)
			count(node, node.left);
		if (node.right != null)
			count(node, node.right);
		if (node.left == null && node.right == null && parent != null && parent.left == node) {
			sum = sum + node.value;
		}
		return;
	}

	public static void main(String args[]) {
		MNode n6 = new MNode(6, null, null);
		MNode n5 = new MNode(5, null, null);
		MNode n4 = new MNode(4, null, null);
		MNode n3 = new MNode(3, null, null);
		MNode n2 = new MNode(2, n5, n6);
		MNode n1 = new MNode(1, n3, n4);
		MNode root = new MNode(0, n1, n2);

		LeftLeafSum leafSum = new LeftLeafSum();
		leafSum.count(null, root);
		System.out.println(leafSum.sum);
	}
}

class MNode {
	public int value;
	public MNode left;
	public MNode right;

	public MNode(int value, MNode left, MNode right) {
		super();
		this.value = value;
		this.left = left;
		this.right = right;
	}

}