package competition.store.s101to120;

import competition.structure.TreeNode;

public class BuildTree {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder==null||inorder==null) return null;
		if(preorder.length==0||inorder.length==0) return null;
		int val = preorder[0];
		TreeNode root = new TreeNode(val);
		int index = 0;
		for(int i=0;i<inorder.length;i++){
			if(val==inorder[i]) {
				index =i ;
				break;
			}
		}

		if(index>0) root.left = generate(1,index,0,index-1,preorder,inorder);
		if(index<inorder.length-1) root.right = generate(index+1, inorder.length-1,index+1,inorder.length-1, preorder, inorder);

		return root;
	}

	private TreeNode generate(int ps,int pe,int is,int ie,int[] preorder,int[] inorder){
//		if(start == end) return new TreeNode(inorder[start]);
		TreeNode root = new TreeNode(preorder[ps]);
		int index =is;
		for(int i=is;i<=ie;i++){
			if(inorder[i]==preorder[ps]){
				index = i;
				break;
			}
		}
		if(index>is) root.left = generate(ps+1,ps+index-is,is, index-1, preorder, inorder);
		if(index<ie) root.right = generate(ps+index-is+1,pe,index+1, ie, preorder, inorder);
		return root;
	}

	public static void main(String[] args) {
		BuildTree buildTree  = new BuildTree();
		int[] preorder = new int[] { 3, 9, 20, 15, 7 };
		int[] inorder = new int[] { 9, 3, 15, 20, 7 };
		TreeNode reTreeNode = buildTree.buildTree(preorder, inorder);
		System.out.println(reTreeNode);
	}

}
