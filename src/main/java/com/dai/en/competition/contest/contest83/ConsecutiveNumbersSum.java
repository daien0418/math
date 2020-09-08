package com.dai.en.competition.contest.contest83;

public class ConsecutiveNumbersSum {
	public int consecutiveNumbersSum(int N) {
        int ret=0;
        int s=0;
        int y=0;

        for(int i=1;;i++){
        	s=N/i;
        	y=N%i;

        	if(y==0){
        		if(s-i/2<=0){
        			break;
        		}

        		if(i%2==1){
        			ret++;
        		}
        	}else{
        		if(s+1-i/2<=0){
        			break;
        		}

        		if(i%2==0){

        			if((s*2+1)*i/2==N){
        				ret++;
        			}
        		}
        	}
        }

        return ret;
    }

	public static void main(String args[]){
		ConsecutiveNumbersSum consecutiveNumbersSum = new ConsecutiveNumbersSum();
		int N = 3;
		System.out.println(consecutiveNumbersSum.consecutiveNumbersSum(N));
	}
}
