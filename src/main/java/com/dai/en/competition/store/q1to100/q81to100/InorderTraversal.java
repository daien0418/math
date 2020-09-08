package com.dai.en.competition.store.q1to100.q81to100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import com.dai.en.competition.structure.TreeNode;

public class InorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Set<TreeNode> set = new HashSet<TreeNode>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			if(set.contains(node)){
				list.add(node.val);
				continue;
			}

			while(node!=null){
				if(node.right!=null){
					stack.push(node.right);
				}
				stack.push(node);
				set.add(node);
				node = node.left;
			}

		}

		return list;
	}

	public static void main (String args[]){
		InorderTraversal inorderTraversal =  new InorderTraversal();
		TreeNode root =  new TreeNode(1);
		root.right =  new TreeNode(2);
		root.right.left = new TreeNode(3);

		for(int a :inorderTraversal.inorderTraversal(root)){
			System.out.print(a);
			System.out.print(" ");
		}
	}

}

