package competition.store.q21to40;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        list.add("");
        for(int i=0;i<n;i++){
        	int size = list.size();
        	for(int j=0;j<size;j++){
        		String curStr = list.get(0);
        		for(int k=0;k<curStr.length()+1;k++){
        			String newStr = curStr.substring(0,k)+"()"+curStr.substring(k,curStr.length());
        			if(!list.contains(newStr)) list.add(newStr);
        		}
        		list.remove(0);
        	}
        }
        return list;
    }
	
	public static void main(String args[]){
		GenerateParenthesis generateParenthesis = new GenerateParenthesis();
		System.out.print(generateParenthesis.generateParenthesis(3));
	}
}
