package competition.store.s901to1000.s981to1000;

import java.util.LinkedList;
import java.util.Queue;

import competition.structure.TreeNode;

public class Cousins993 {
	public boolean isCousins(TreeNode root, int x, int y) {
        int xHeight=0;
        int yHeight=0;
        boolean xFound = false;
        boolean yFound = false;
        TreeNode xFather = null;
        TreeNode yFather = null;
        int level = 0;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();

        if(root.val == x){
            xFound =true;
            xHeight = 0;
        }
        if(root.val == y){
            yFound =true;
            yHeight = 0;
        }

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left!=null){
                if(!xFound&&node.left.val==x){
                    xHeight = level+1;
                    xFather = node;
                    xFound = true;
                }
                if(!yFound&&node.left.val==y){
                    yHeight = level+1;
                    yFather = node;
                    yFound = true;
                }
                queue2.offer(node.left);
            }
            if(node.right !=null){
                if(!xFound&&node.right.val == x){
                    xHeight = level+1;
                    xFather = node;
                    xFound = true;
                }
                if(!yFound&&node.right.val == y){
                    yHeight = level+1;
                    yFather = node;
                    yFound = true;
                }
                queue2.offer(node.right);
            }

            if(xFound&&yFound){
                break;
            }
            if(queue.isEmpty()){
                Queue<TreeNode> temp = queue;
                queue = queue2;
                queue2 = temp;
                level++;
            }
        }

       return xHeight==yHeight?(xFather==yFather?false:true):false;
    }
}
