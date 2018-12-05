package competition.contest.contest94;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimilarNode {
	
	private void init(TreeNode root,List list){
		if(root ==null)
			return;
		if(root.left==null&&root.right==null)
			list.add(root);
		init(root.left, list);
		init(root.right, list);
	}
	
	public boolean leafSimilar2(TreeNode root1, TreeNode root2){
		ArrayList<TreeNode> leftList= new ArrayList<TreeNode>();
		ArrayList<TreeNode> rightList =new ArrayList<TreeNode>();
		init(root1, leftList);
		init(root2, rightList);
		if(leftList.size()!=rightList.size())
			return false;
		for(int i=0;i<leftList.size();i++){
			if(leftList.get(i).val!=rightList.get(i).val){
				return false;
			}
		}
		return true;
	}
	
	
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		stack1.push(root1);
		stack2.push(root2);
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			TreeNode node1 = null;
			while (!stack1.isEmpty()) {
				TreeNode node =stack1.pop();
				if(node==null)
					continue;
				if(node.left==null&&node.right==null){
					node1 = node;
					break;
				}
				stack1.push(node.right);
				stack1.push(node.left);
			}

			TreeNode node2 = null;
			while (!stack2.isEmpty()) {
				TreeNode node =stack2.pop();
				if(node==null)
					continue;
				if(node.left==null&&node.right==null){
					node2 = node;
					break;
				}
				stack2.push(node.right);
				stack2.push(node.left);
			}
			
			int a=node1==null?0:node1.val;
			int b=node2==null?0:node2.val;
			if(a!=b)
				return false;
		}

		return true;
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}