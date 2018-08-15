package competition.store.q81to100;

import java.util.Stack;

public class IsSameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {
//		if(p==null&&q==null) return true;
//		if((p!=null&&q==null)||(p==null&&q!=null)) return false;
//		if(p.val!=q.val) return false;
//
//		return isSameTree(p.left,q.left)&&isSameTree(p.right, q.right);

		Stack<TreeNode> pStack = new Stack<TreeNode>();
		Stack<TreeNode> qStack = new Stack<TreeNode>();
		pStack.push(p);
		qStack.push(q);

		while(!pStack.isEmpty()&&!qStack.isEmpty()){
			 p = pStack.pop();
			 q = qStack.pop();
			 if((p==null&&q!=null)||(p!=null&&q==null)) return false;
			 if(p!=null&&q!=null){
				 if(p.val!=q.val) return false;
				 pStack.push(p.right);
				 pStack.push(p.left);
				 qStack.push(q.right);
				 qStack.push(q.left);
			 }
		}

		if(!pStack.isEmpty()||!qStack.isEmpty()) return false;
		return true;
	}

	public static void main(String[] args) {

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
