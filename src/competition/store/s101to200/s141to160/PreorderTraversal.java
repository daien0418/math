package competition.store.s101to200.s141to160;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import competition.structure.TreeNode;

public class PreorderTraversal {

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if(root!=null) stack.push(root);
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			list.add(node.val);
			if(node.right!=null) stack.push(node.right);
			if(node.left!=null) stack.push(node.left);
		}

		return list;
    }

	public static void main(String[] args) {

	}

}

