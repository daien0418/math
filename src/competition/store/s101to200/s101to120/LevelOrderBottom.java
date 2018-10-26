package competition.store.s101to200.s101to120;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import competition.structure.TreeNode;

public class LevelOrderBottom {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        	list.add(0, newList);
        }

        return list;
    }

	public static void main(String[] args) {

	}

}
