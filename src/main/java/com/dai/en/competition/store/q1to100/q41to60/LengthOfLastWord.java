package com.dai.en.competition.store.q1to100.q41to60;

public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
        s= s.trim();
        for(int i=s.length()-1;i>=0;i--){
        	if(s.charAt(i)==' '){
        		return s.length()-1- i;
        	}
        }

        return s.length()==0?0:s.length();
    }
}
