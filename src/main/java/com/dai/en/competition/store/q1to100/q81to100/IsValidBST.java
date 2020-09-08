package com.dai.en.competition.store.q1to100.q81to100;

import java.util.ArrayList;
import java.util.List;

import com.dai.en.competition.structure.TreeNode;

public class IsValidBST {

	List<Integer> list = new ArrayList<Integer>();
	public boolean isValidBST(TreeNode root) {
		preSort(root);
		for(int i=0;i<list.size()-1;i++){
			if(list.get(i)>list.get(i+1)){
				return false;
			}
		}
		return true;
	}

	private void preSort(TreeNode root){
		if(root==null) return;
		preSort(root.left);
		list.add(root.val);
		preSort(root.right);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.right =new TreeNode(4);
		root.right.left=new TreeNode(3);
		root.right.right = new TreeNode(6);

		IsValidBST isValidBST = new IsValidBST();
		isValidBST.isValidBST(root);
	}

}
