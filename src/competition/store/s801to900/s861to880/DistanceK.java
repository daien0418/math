package competition.store.s801to900.s861to880;

import java.util.ArrayList;
import java.util.List;

import competition.structure.TreeNode;

public class DistanceK {

	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		List<Integer> list = new ArrayList<Integer>();
		List<TreeNode> nodeList = find(root, target, new ArrayList<TreeNode>());

		for (int i = nodeList.size() - 1; i >= 0; i--) {
			if (K >= 0) {
				if (i + 1 <= nodeList.size() - 1) {
					if (nodeList.get(i + 1) == nodeList.get(i).left) {
						nodeList.get(i).left = null;
					} else {
						nodeList.get(i).right = null;
					}
				}
				findK(nodeList.get(i), K, 0, list);
			}
			K--;
		}

		return list;
	}

	private void findK(TreeNode root, int k, int cur, List<Integer> list) {
		if (root == null)
			return;
		if (cur == k) {
			list.add(root.val);
			return;
		} else {
			findK(root.left, k, cur + 1, list);
			findK(root.right, k, cur + 1, list);
		}
	}

	private List<TreeNode> find(TreeNode root, TreeNode target, List<TreeNode> list) {
		if (root == null)
			return null;
		if (root.val == target.val) {
			list.add(root);
		} else {
			list.add(root);
			List<TreeNode> leftList = find(root.left, target, new ArrayList<TreeNode>(list));
			if (leftList != null && leftList.get(leftList.size() - 1).val == target.val) {
				return leftList;
			}

			List<TreeNode> rightList = find(root.right, target, new ArrayList<TreeNode>(list));
			if (rightList != null && rightList.get(rightList.size() - 1).val == target.val) {
				return rightList;
			}
		}

		return list;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);

		DistanceK distanceK = new DistanceK();
		List<Integer> list = distanceK.distanceK(root, new TreeNode(5), 2);
		System.out.println(list.get(0));
	}

}
