package com.dai.en.questions;
import java.util.Stack;

import com.dai.en.competition.structure.TreeNode;

public class BinaryTreeCopy {

	/**
	 * 递归拷贝
	 *
	 * @param c
	 * @param r
	 */
	public void copy(TreeNode c, TreeNode r) {
		if (c == null || r == null)
			return;
		c.left = r.left == null ? null : new TreeNode(r.left.val, null, null);
		c.right = r.right == null ? null : new TreeNode(r.right.val, null, null);
		copy(c.left, r.left);
		copy(c.right, r.right);
	}

	/**
	 *  递归拷贝
	 *
	 * @param r
	 * @return
	 */
	public TreeNode copy2(TreeNode r) {
		if (r == null)
			return null;
		TreeNode TreeNode = new TreeNode(r.val, copy2(r.left), copy2(r.right));
		return TreeNode;
	}

	/**
	 * 非递归拷贝
	 * 两个stack；一边同步两个stack一边新建
	 *
	 * @param r
	 * @return
	 */
	public TreeNode copy3(TreeNode r) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<TreeNode> cStack = new Stack<TreeNode>();
		stack.push(r);
		TreeNode retTreeNode = new TreeNode(r.val, null, null);
		cStack.push(retTreeNode);
		while (!stack.isEmpty()) {
			TreeNode TreeNode = stack.pop();
			TreeNode cTreeNode = cStack.pop();
			if (TreeNode == null)
				continue;
			TreeNode rTreeNode = TreeNode.right == null ? null : new TreeNode(TreeNode.right.val, null, null);
			TreeNode lTreeNode = TreeNode.left == null ? null : new TreeNode(TreeNode.left.val, null, null);
			cTreeNode.left = lTreeNode;
			cTreeNode.right = rTreeNode;
			stack.push(TreeNode.right);
			stack.push(TreeNode.left);
			cStack.push(rTreeNode);
			cStack.push(lTreeNode);
		}
		return retTreeNode;
	}

	/**
	 * 前序非递归
	 *
	 * @param r
	 */
	public void print2(TreeNode r) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(r);
		while (!stack.isEmpty()) {
			TreeNode TreeNode = stack.pop();
			if (TreeNode == null)
				continue;
			System.out.println(TreeNode.val);
			stack.push(TreeNode.right);
			stack.push(TreeNode.left);
		}
	}

	/**
	 * 中序非递归
	 *
	 * @param r
	 */
	public void inPrint(TreeNode r){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(r!=null||!stack.isEmpty()){
			while(r!=null){
				stack.push(r);
				r=r.left;
			}

			r=stack.pop();
			System.out.println(r.val);
			r=r.right;
		}
	}

	public void inPrint2(TreeNode r){
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    stack.push(r);
	    while(!stack.isEmpty()){
	        r = stack.pop();
	        if(r==null)
	            continue;
	        if(r.left==null&&r.right==null){
	            System.out.println(r.val);
	            continue;
	        }
	        stack.push(r.right);
	        stack.push(r);
	        stack.push(r.left);
	        r.left = null;
	        r.right = null;
	    }
	}

	/**
	 * 后序非递归
	 *	passed为刚刚访问过的节点
	 * @param r
	 */
	public void postPrint(TreeNode r){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode passed=null;
		while(r!=null||!stack.isEmpty()){
			while (r != null) {
                stack.push(r);
                r = r.left;
            }

            if (!stack.isEmpty()) {
                r = stack.peek().right;
                if (r == null || r == passed) {
                    r = stack.pop();
                    System.out.println(r.val);
                    passed = r;
                    r = null;
                }
            }
		}
	}

	public static void postPrint2(TreeNode r){
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    stack.push(r);
	    while(!stack.isEmpty()){
	        r = stack.pop();
	        if(r==null){
	           continue;
	        }
	        if(r.left == null&&r.right == null){
	            System.out.println(r.val);
	            continue;
	        }
	        stack.push(r);
	        stack.push(r.right);
	        stack.push(r.left);
	        r.left = null;
	        r.right = null;
	    }
	}

	/**
	 * 层次遍历
	 * 两个stack实现queue
	 *
	 * @param r
	 */
	public void print3(TreeNode r){
		Stack<TreeNode> inStack = new Stack<TreeNode>();
		Stack<TreeNode> outStack = new Stack<TreeNode>();
		inStack.push(r);
		while(!inStack.isEmpty()||!outStack.isEmpty()){
			if(outStack.isEmpty()){
				while(!inStack.isEmpty()){
					outStack.push(inStack.pop());
				}
			}

			TreeNode TreeNode = outStack.pop();
			if(TreeNode == null)
				continue;
			System.out.println(TreeNode.val);
			inStack.push(TreeNode.left);
			inStack.push(TreeNode.right);
		}
	}

	/**
	 * 调整System.out.print语句的位置
	 * 实现前序、中序、后序遍历
	 *
	 * @param root
	 */
	public void print(TreeNode root) {
		if (root == null)
			return;
		System.out.println(root.val);
		print(root.left);
		print(root.right);
	}

	public static void main(String args[]) {
		/**
		 * 			0
		 * 		  1    2
		 *     3     4
		 *         5    6
		 *
		 */
		TreeNode r3 = new TreeNode(6, null, null);
		TreeNode l3 = new TreeNode(5, null, null);
		TreeNode r2 = new TreeNode(4, l3, r3);
		TreeNode l2 = new TreeNode(3, null, null);
		TreeNode r = new TreeNode(2, null, null);
		TreeNode l = new TreeNode(1, l2, r2);
		TreeNode root = new TreeNode(0, l, r);
		BinaryTreeCopy binaryTreeCopy = new BinaryTreeCopy();
		binaryTreeCopy.postPrint2(root);
		// binaryTreeCopy.print2(root);
		// TreeNode copyRoot = new TreeNode(root.val, null, null);
		// binaryTreeCopy.copy(copyRoot, root);
		// binaryTreeCopy.print(copyRoot);
		//
		// copyRoot = binaryTreeCopy.copy2(root);
		// binaryTreeCopy.print(copyRoot);

//		TreeNode copyRoot = binaryTreeCopy.copy3(root);
//		binaryTreeCopy.print(copyRoot);
	}

}
