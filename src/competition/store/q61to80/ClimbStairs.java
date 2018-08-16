package competition.store.q61to80;

public class ClimbStairs {

	public int climbStairs(int n) {
		int ret = 0;
		int i=0;
		while(i*2<=n){
//			ret = ret + c(i,(n-i*2)+i);
			i=i+1;
		}

		return ret;
	}

	public static void main(String[] args) {
		ClimbStairs climbStairs = new ClimbStairs();
		System.out.println(climbStairs.climbStairs(19));
	}

}
