package com.dai.en.competition.store.s101to200.s101to120;

import com.dai.en.competition.structure.TreeLinkNode;

public class Connect2 {

	public void connect(TreeLinkNode root) {
		if (root != null) {
			subConnect(root.left, root.right, root.next);
		}
	}

	private void subConnect(TreeLinkNode left, TreeLinkNode right, TreeLinkNode uncle) {
		if (left != null){
			if(right!=null){
				left.next = right;
				right.next = uncle==null?null:uncle.left!=null?uncle.left:uncle.right==null?uncleNext(uncle.next):uncle.right;
			}else{
				left.next=uncle==null?null:uncle.left!=null?uncle.left:uncle.right==null?uncleNext(uncle.next):uncle.right;
			}
		}else{
			if(right!=null){
				right.next=uncle==null?null:uncle.left!=null?uncle.left:uncle.right==null?uncleNext(uncle.next):uncle.right;
			}else{
				return;
			}
		}

		if(right!=null){
			subConnect(right.left, right.right, right.next);
		}

		if(left!=null){
			subConnect(left.left, left.right, left.next);
		}

	}

	private TreeLinkNode uncleNext(TreeLinkNode uncle){
		if(uncle==null) return null;
		if(uncle.left!=null) return uncle.left;
		if(uncle.right!=null) return uncle.right;
		return uncleNext(uncle.next);
	}

	public static void main(String[] args) {

	}

}
