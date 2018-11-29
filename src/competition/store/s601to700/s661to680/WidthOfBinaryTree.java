package competition.store.s601to700.s661to680;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

import competition.structure.TreeNode;

public class WidthOfBinaryTree {

	public int widthOfBinaryTree(TreeNode root) {
		int max = 0;

		List<TreeNode> inList = new ArrayList<>();
		List<TreeNode> outList = new ArrayList<>();
		if (root != null) {
			max = 1;
			inList.add(root);
		}

		while (inList.size() > 0) {
			for (TreeNode node : inList) {
				if (node != null) {
					outList.add(node.left);
					outList.add(node.right);
				} else {
					outList.add(null);
					outList.add(null);
				}
			}

			int leftNull = 0;
			for (int i = 0; i < outList.size(); i++) {
				if (outList.get(i) == null) {
					leftNull++;
				} else {
					break;
				}
			}

			if (leftNull >= outList.size()) {
				break;
			} else {
				for (int i = 0; i < leftNull; i++) {
					outList.remove(0);
				}
			}

			for (int i = outList.size() - 1; i >= 0; i--) {
				if (outList.get(i) == null) {
					outList.remove(i);
				} else {
					break;
				}
			}

			if (outList.size() == 0)
				break;
			if (outList.size() > max)
				max = outList.size();

			inList = new ArrayList<>(outList);
			outList.clear();
		}

		return max;
	}

	public static void main(String[] args) {

	}

}
