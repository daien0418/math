package competition.store.q1to100.q1to20;

public class ReverseNumber {
	public int reverse(int x) {
        int ret=0;
        int flag=x<0?-1:1;
        x=Math.abs(x);

        while(x>0){
        	if(ret>Integer.MAX_VALUE/10){
        		return 0;
        	}
        	ret=10*ret+x%10;
        	x=x/10;
        }

        if(flag<0){
        	ret= ret*-1;
        }

        return ret;
    }
}
