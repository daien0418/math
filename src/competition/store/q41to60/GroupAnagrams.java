package competition.store.q41to60;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GroupAnagrams {
	
	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(int i=0;i<strs.length;i++){
        	String curStr = strs[i];
        	char[] curChars =curStr.toCharArray();
        	Arrays.sort(curChars);
        	
        	if(map.size()==0){
        		List<String> newList = new ArrayList<String>();
        		newList.add(curStr);
        		map.put(String.valueOf(curChars), newList);
        		continue;
        	}
        	
        	if(map.containsKey(String.valueOf(curChars))){
        		map.get(String.valueOf(curChars)).add(curStr);
        	}else{
        		List<String> newList = new ArrayList<String>();
        		newList.add(curStr);
        		map.put(String.valueOf(curChars), newList);
        	}
        	
        }
        
        for(String key:map.keySet()){
        	list.add(map.get(key));
        }
        return list;
    }
	
	public static void main(String[] args) {
		GroupAnagrams groupAnagrams = new GroupAnagrams();
//		String[] strs = new String[]{"","b"};
		String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
		for(List<String> list :groupAnagrams.groupAnagrams(strs)){
			System.out.println();
			for(String string :list){
				System.out.print(string);System.out.print(" ");
			}
		}
	}

}
