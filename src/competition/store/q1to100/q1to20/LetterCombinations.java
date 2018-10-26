package competition.store.q1to100.q1to20;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
	public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();
        if(digits.equals(""))
        	return list;
        list.add(new String(""));
        for(int i=0;i<digits.length();i++){
        	String[] set = find(digits.charAt(i));
        	int l = list.size();
        	for(int j=0;j<l;j++){
        		String cur = list.get(0);
        		for(int k=0;k<set.length;k++){
        			list.add(cur+set[k]);
        		}
        		list.remove(0);
        	}

        }
        return list;
    }

	private String[] find(char c){
		switch (c) {
		case '2':
			return new String[]{"a","b","c"};
		case '3':
			return new String[]{"d","e","f"};
		case '4':
			return new String[]{"g","h","i"};
		case '5':
			return new String[]{"j","k","l"};
		case '6':
			return new String[]{"m","n","o"};
		case '7':
			return new String[]{"p","q","r","s"};
		case '8':
			return new String[]{"t","u","v"};
		case '9':
			return new String[]{"w","x","y","z"};
		default:
			return null;
		}
	}

	public static void main(String args[]){
		LetterCombinations letterCombinations = new LetterCombinations();
		String digits = "2345678";
		System.out.println(letterCombinations.letterCombinations(digits));
	}

}
