package com.dai.en.competition.store.q1to100.q1to20;

public class MyAtoi {
	public int myAtoi(String str) {
        int ret=0;
        str=str.trim();

        char[] chars = str.toCharArray();
        if(chars.length==0) return 0;
        if(chars[0]!='+'&&chars[0]!='-'&&(chars[0]<48||chars[0]>57)) return 0;

        int f = 1;
        String temp="";
        for(int i=0;i<chars.length;i++){
        	if(i==0){
        		if(chars[i]=='-'){
        			f=-1;
        			continue;
        		}
        		if(chars[i]=='+'){
        			continue;
        		}
        	}
        	if(chars[i]>=48&&chars[i]<=57){
        		temp=temp+chars[i];
        	}else{
        		break;
        	}
        }

        if(temp.equals("")) return 0;

        try {
        	Integer.parseInt(temp);
        	ret = Integer.parseInt(temp) *f;
		} catch (Exception e) {
			if(f==1) return Integer.MAX_VALUE;
        	if(f==-1) return Integer.MIN_VALUE;
		}

//        if(String.valueOf(Integer.parseInt(temp)).equals(temp)){
//        	ret = Integer.parseInt(temp) *f;
//        }else{
//        	if(f==1) return Integer.MAX_VALUE;
//        	if(f==-1) return Integer.MIN_VALUE;
//        }

        return ret;
    }

	public static void main(String args[]){
		MyAtoi myAtoi= new MyAtoi();
		String s = "-91283472332";
		System.out.println(myAtoi.myAtoi(s));
	}

}
