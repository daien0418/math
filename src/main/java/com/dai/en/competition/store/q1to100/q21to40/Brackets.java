package com.dai.en.competition.store.q1to100.q21to40;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 32,最大括号长度
 *
 * @author daien
 * @date 2020年12月28日
 */
public class Brackets {

    public static void main(String args[]){
        Brackets brackets = new Brackets();
        String s = "()(())";
        int result = brackets.longestValidParentheses(s);
        System.out.println(result);
    }

    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        ArrayList<Node> list =new ArrayList<Node>();
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<chars.length;i++){
            Character c = chars[i];
            if(c==')'){
                if(stack.isEmpty()){
                    stack.push(i);
                }
                else if(chars[stack.peek()]=='('){
                    Node node= new Node();
                    node.left = stack.pop();
                    node.right = i;
                    merge(list, node);
                }
            }else{
                stack.push(i);
            }
        }

        int maxLength=0;
        for(Node node:list){
            maxLength = Math.max(maxLength, node.right-node.left+1);
        }
        return maxLength;
    }

    public void merge(List<Node> list,Node node){
        if(list.size()==0){
            list.add(node);
        }else{
            Node tail = list.get(list.size()-1);
            if(node.left-tail.right>1){
                list.add(node);
                return;
            }else if(node.left-tail.right==1){
                node.left=tail.left;
                list.remove(list.size()-1);
                merge(list,node);
            }else{
                list.remove(list.size()-1);
                merge(list,node);
            }
        }
    }

    class Node{
        int left;
        int right;
    }

}
