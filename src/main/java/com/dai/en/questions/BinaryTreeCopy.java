package com.dai.en.questions;
import java.util.Stack;

public class BinaryTreeCopy {

	/**
	 * 递归拷贝
	 *
	 * @param c
	 * @param r
	 */
	public void copy(Node c, Node r) {
		if (c == null || r == null)
			return;
		c.left = r.left == null ? null : new Node(r.left.value, null, null);
		c.right = r.right == null ? null : new Node(r.right.value, null, null);
		copy(c.left, r.left);
		copy(c.right, r.right);
	}

	/**
	 *  递归拷贝
	 *
	 * @param r
	 * @return
	 */
	public Node copy2(Node r) {
		if (r == null)
			return null;
		Node node = new Node(r.value, copy2(r.left), copy2(r.right));
		return node;
	}

	/**
	 * 非递归拷贝
	 * 两个stack；一边同步两个stack一边新建
	 *
	 * @param r
	 * @return
	 */
	public Node copy3(Node r) {
		Stack<Node> stack = new Stack<Node>();
		Stack<Node> cStack = new Stack<Node>();
		stack.push(r);
		Node retNode = new Node(r.value, null, null);
		cStack.push(retNode);
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			Node cNode = cStack.pop();
			if (node == null)
				continue;
			Node rNode = node.right == null ? null : new Node(node.right.value, null, null);
			Node lNode = node.left == null ? null : new Node(node.left.value, null, null);
			cNode.left = lNode;
			cNode.right = rNode;
			stack.push(node.right);
			stack.push(node.left);
			cStack.push(rNode);
			cStack.push(lNode);
		}
		return retNode;
	}

	/**
	 * 前序非递归
	 *
	 * @param r
	 */
	public void print2(Node r) {
		Stack<Node> stack = new Stack<Node>();
		stack.push(r);
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			if (node == null)
				continue;
			System.out.println(node.value);
			stack.push(node.right);
			stack.push(node.left);
		}
	}

	/**
	 * 中序非递归
	 *
	 * @param r
	 */
	public void inPrint(Node r){
		Stack<Node> stack = new Stack<Node>();
		while(r!=null||!stack.isEmpty()){
			while(r!=null){
				stack.push(r);
				r=r.left;
			}

			r=stack.pop();
			System.out.println(r.value);
			r=r.right;
		}
	}

	/**
	 * 后序非递归
	 *	passed为刚刚访问过的节点
	 * @param r
	 */
	public void postPrint(Node r){
		Stack<Node> stack = new Stack<Node>();
		Node passed=null;
		while(r!=null||!stack.isEmpty()){
			while (r != null) {
                stack.push(r);
                r = r.left;
            }

            if (!stack.isEmpty()) {
                r = stack.peek().right;
                if (r == null || r == passed) {
                    r = stack.pop();
                    System.out.println(r.value);
                    passed = r;
                    r = null;
                }
            }
		}
	}
	/**
	 * 层次遍历
	 * 两个stack实现queue
	 *
	 * @param r
	 */
	public void print3(Node r){
		Stack<Node> inStack = new Stack<Node>();
		Stack<Node> outStack = new Stack<Node>();
		inStack.push(r);
		while(!inStack.isEmpty()||!outStack.isEmpty()){
			if(outStack.isEmpty()){
				while(!inStack.isEmpty()){
					outStack.push(inStack.pop());
				}
			}

			Node node = outStack.pop();
			if(node == null)
				continue;
			System.out.println(node.value);
			inStack.push(node.left);
			inStack.push(node.right);
		}
	}

	/**
	 * 调整System.out.print语句的位置
	 * 实现前序、中序、后序遍历
	 *
	 * @param root
	 */
	public void print(Node root) {
		if (root == null)
			return;
		System.out.println(root.value);
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
		Node r3 = new Node("6", null, null);
		Node l3 = new Node("5", null, null);
		Node r2 = new Node("4", l3, r3);
		Node l2 = new Node("3", null, null);
		Node r = new Node("2", null, null);
		Node l = new Node("1", l2, r2);
		Node root = new Node("0", l, r);
		BinaryTreeCopy binaryTreeCopy = new BinaryTreeCopy();
		binaryTreeCopy.postPrint(root);
		// binaryTreeCopy.print2(root);
		// Node copyRoot = new Node(root.value, null, null);
		// binaryTreeCopy.copy(copyRoot, root);
		// binaryTreeCopy.print(copyRoot);
		//
		// copyRoot = binaryTreeCopy.copy2(root);
		// binaryTreeCopy.print(copyRoot);

//		Node copyRoot = binaryTreeCopy.copy3(root);
//		binaryTreeCopy.print(copyRoot);
	}

}

 class Node {
	public String value;
	public Node left;
	public Node right;

	public Node(String value, Node left, Node right) {
		super();
		this.value = value;
		this.left = left;
		this.right = right;
	}

}