package com.dai.en.competition.store.s801to900.s881to900;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.dai.en.competition.structure.TreeNode;

public class AllPossibleFBT {

	public List<TreeNode> allPossibleFBT(int N) {
		List<TreeNode> list = generate(N);
		return list;
	}

	private List<TreeNode> generate(int n) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		if (n == 1) {
			list.add(new TreeNode(0));
		} else {
			int leftN = 1;
			int rightN = n - 1 - leftN;

			while (rightN > 0) {
				List<TreeNode> leftList = generate(leftN);
				List<TreeNode> rightList = generate(rightN);

				for (int i = 0; i < leftList.size(); i++) {
					for (int j = 0; j < rightList.size(); j++) {
						TreeNode rNode = new TreeNode(0);
						rNode.left = leftList.get(i);
						rNode.right = rightList.get(j);
						list.add(rNode);
					}
				}

				leftN = leftN + 2;
				rightN = rightN - 2;
			}
		}

		return list;
	}

	public static void main(String[] args) {
		AllPossibleFBT allPossibleFBT = new AllPossibleFBT();
		List<TreeNode> list = allPossibleFBT.allPossibleFBT(7);
		System.out.println("size£º" + list.size());
		for (TreeNode node : list) {
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.offer(node);
			while (!queue.isEmpty()) {
				TreeNode popNode = queue.poll();
				System.out.print(popNode.val + ",");
				if (popNode.left == null) {
					System.out.print("null,");
				} else {
					queue.offer(popNode.left);
				}
				if (popNode.right == null) {
					System.out.print("null,");
				} else {
					queue.offer(popNode.right);
				}
			}
			System.out.println(" ");
		}
	}

}
