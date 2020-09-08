package com.dai.en.questions;
import java.util.Stack;

public class RevertList {

	public static Node end;

	public static void main(String args[]){
		Node a = new Node();a.value=1;
		Node b = new Node();b.value=2;
		Node c= new Node();c.value=3;
		Node d = new Node();d.value=4;
		c.next = d;b.next = c;a.next = b;
		RevertList revertList = new RevertList();
		revertList.sort2(a);
		revertList.print(end);
	}

	public void print(Node header){
		while (header!=null) {
			System.out.println(header.value);
			header = header.next;
		}
	}

	/**
	 * µÝ¹é
	 *
	 * @param header
	 * @return
	 */
	public Node sort(Node header){
		if(header == null){
			return null;
		}
		if(header.next==null){
			end = header;
			return header;
		}else{
			Node tmp = header.next;
			header.next=null;
			tmp = sort(tmp);
			tmp.next=header;
		}

		return header;
	}

	/**
	 * ·ÇµÝ¹é
	 *
	 * @param header
	 * @return
	 */
	public Node sort2(Node header){
		Stack<Node> stack = new Stack<Node>();
		while(header!=null){
			stack.push(header);
			Node next = header.next;
			header.next = null;
			header = next;
		}
		end = stack.pop();
		header = end;
		while(!stack.isEmpty()){
			header.next = stack.pop();
			header = header.next;
		}
		return end;
	}

	static class Node{
		int value;
		Node next;
	}

}
