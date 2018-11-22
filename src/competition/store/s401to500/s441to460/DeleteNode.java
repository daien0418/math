package competition.store.s401to500.s441to460;

import competition.structure.TreeNode;

public class DeleteNode {

	public TreeNode deleteNode(TreeNode root, int key) {
		TreeNode parent = null;
		TreeNode son = root;

		while (son != null) {
			if (son.val == key) {
				break;
			} else if (son.val > key) {
				parent = son;
				son = son.left;
			} else {
				parent = son;
				son = son.right;
			}
		}

		if (son == null) {
			return root;
		}

		TreeNode subSon = null;
		if (son.left != null) {
			subSon = son.left;
			if (son.right != null) {
				TreeNode temp = son.left;
				while (temp.right != null) {
					temp = temp.right;
				}
				temp.right = son.right;
			}
		} else {
			subSon = son.right;
		}
		son.left = null;
		son.right = null;
		if (parent == null) {
			return subSon;
		} else {
			if (parent.left == son) {
				parent.left = subSon;
			} else {
				parent.right = subSon;
			}
		}

		return root;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		DeleteNode deleteNode = new DeleteNode();
		TreeNode treeNode = deleteNode.deleteNode(root, 6);
		System.out.println(treeNode.val);
	}

}
