package competition.store.s101to120;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import competition.structure.TreeNode;

public class ZigzagLevelOrder {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		if (root != null)
			s1.push(root);

		TreeNode node = null;
		boolean reverse = true;
		while (!s1.isEmpty()) {
			List<Integer> newList = new ArrayList<Integer>();
			while (!s1.isEmpty()) {
				node = s1.pop();
				if(reverse){
					newList.add(node.val);
				}else{
					newList.add(0,node.val);
				}
				if (node.left != null)
					s2.push(node.left);
				if (node.right != null)
					s2.push(node.right);
			}

			while (!s2.isEmpty()) {
				s1.push(s2.pop());
			}
			list.add(newList);
			reverse = !reverse;
		}

		return list;
	}

	public static void main(String[] args) {

	}

}
