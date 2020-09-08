package com.dai.en.competition.store.q1to100.q21to40;

public class CountAndSay {
	public String countAndSay(int n) {
        if(n==1) return "1";
        if(n==2) return "11";
        String last = countAndSay(n-1);
        String ret="";
        for(int i=0;i<last.length();i++){
        	int j=i;
        	while(j<last.length()-1&&last.charAt(j)==last.charAt(j+1)){
        		j++;
        	}
        	ret = ret + (j-i+1)+last.charAt(i);
        	if(j>i){
        		i=j;
        	}
        }
        return ret;
	}

	public static void main(String args[]){
		CountAndSay countAndSay = new CountAndSay();
		System.out.println(countAndSay.countAndSay(6));
	}
}
