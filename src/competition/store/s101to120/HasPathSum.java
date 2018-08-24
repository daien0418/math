package competition.store.s101to120;

import java.util.ArrayList;
import java.util.List;

import competition.structure.TreeNode;

public class HasPathSum {

	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) return false;
		List<Integer> list = sumList(root);
		for(int val :list){
			if(val==sum) return true;
		}
		return false;
	}

	private List<Integer> sumList(TreeNode root){
		List<Integer> list  = new ArrayList<Integer>();
		if(root.left==null&&root.right==null){
			list.add(root.val);
			return list;
		}
		if(root.left!=null){
			List<Integer> leftList = sumList(root.left);
			for(int ret : leftList){
				list.add((root.val+ret));
			}
		}

		if(root.right!=null){
			List<Integer> rightList = sumList(root.right);
			for(int ret : rightList){
				list.add((root.val+ret));
			}
		}

		return list;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left= new TreeNode(7);
		root.left.left.right= new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);

		HasPathSum hasPathSum = new HasPathSum();
		hasPathSum.hasPathSum(root,22);
	}

}
