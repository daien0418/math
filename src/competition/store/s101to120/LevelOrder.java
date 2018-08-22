package competition.store.s101to120;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import competition.store.s101to120.IsSymmetric.TreeNode;

public class LevelOrder {

	public List<List<Integer>> levelOrder(TreeNode root) {
		  List<List<Integer>> list = new ArrayList<List<Integer>>();
	        Stack<TreeNode> s1 = new Stack<TreeNode>();
	        Stack<TreeNode> s2 = new Stack<TreeNode>();
	        if(root!=null) s1.push(root);

	        TreeNode node = null;
	        while(!s1.isEmpty()){
	        	List<Integer> newList = new ArrayList<Integer>();
	        	while(!s1.isEmpty()){
	        		node = s1.pop();
	        		newList.add(node.val);
	        		if(node.left!=null) s2.push(node.left);
	        		if(node.right!=null) s2.push(node.right);
	        	}

	        	while(!s2.isEmpty()){
	        		s1.push(s2.pop());
	        	}
	        	list.add(newList);
	        }

	        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
