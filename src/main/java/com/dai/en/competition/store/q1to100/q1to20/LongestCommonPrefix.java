package com.dai.en.competition.store.q1to100.q1to20;

public class LongestCommonPrefix {
	 	public String longestCommonPrefix(String[] strs) {
	        String ret="";
	        char cur=0;

	        if(strs==null)
	        	return "";
	        for(int j=0,i=0;j<strs.length;j=(j+1)%strs.length){
	        	if(strs[j].length()<=i)
	        		break;
	        	if(cur==0){
	        		cur=strs[j].charAt(i);
	        		continue;
	        	}
	        	if(cur!=strs[j].charAt(i)){
	        		break;
	        	}
	        	if(j==strs.length-1){
	        		ret = ret+cur;
	        		cur=0;
	        		i++;
	        	}
	        }

	        return ret;
	    }

	 	public static void main (String args[]){
	 		LongestCommonPrefix longestCommonPrefix= new LongestCommonPrefix();
	 		String[] strs = new String[]{""};
	 		System.out.println(longestCommonPrefix.longestCommonPrefix(strs));
	 	}

}
