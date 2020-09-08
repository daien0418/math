package com.dai.en.competition.store.s1001to1200.s1001to1100;

import com.dai.en.competition.structure.TreeNode;

public class Solution1008 {

	 public TreeNode bstFromPreorder(int[] preorder) {
	        TreeNode root = new TreeNode(preorder[0]);
	        for(int i=1;i<preorder.length;i++){
	            TreeNode temp = root;
	            while(true){
	                if(preorder[i]<temp.val){
	                    if(temp.left == null){
	                        temp.left = new TreeNode(preorder[i]);
	                        break;
	                    }
	                    temp = temp.left;
	                }else{
	                    if(temp.right == null){
	                        temp.right = new TreeNode(preorder[i]);
	                        break;
	                    }
	                    temp = temp.right;
	                }
	            }
	        }

	        return root;
	    }
}
