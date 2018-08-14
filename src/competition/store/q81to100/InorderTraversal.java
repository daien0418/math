package competition.store.q81to100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import competition.store.q81to100.DeleteDuplicates.ListNode;

public class InorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			if(node.right!=null){
				stack.push(node.right);
			}

			TreeNode cur = node.left;
			while(cur!=null){
				if(cur.right!=null){
					stack.push(cur.right);
				}

			}
		}

		return list;
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
