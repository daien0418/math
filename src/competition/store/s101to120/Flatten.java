package competition.store.s101to120;

import competition.structure.TreeNode;

public class Flatten {

	public void flatten(TreeNode root) {
		TreeNode node = root;
		while(node!=null){
			if(node.left!=null){
				TreeNode right = node.right;
				TreeNode left = node.left;
				node.right = node.left;
				node.left =null;

				if(right!=null){
					while(left.right!=null){
						left=left.right;
					}
					left.right = right;
				}
			}
			node = node.right;
		}
	}

	public static void main(String[] args) {

	}

}
