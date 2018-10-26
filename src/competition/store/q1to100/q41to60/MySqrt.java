package competition.store.q1to100.q41to60;

public class MySqrt {
	public int mySqrt(int x) {
		int low = 0;
		int high = x;
		int mid = 0;
		long temp = 0;
		while(low<=high){
			mid = (low + high)/2;
			temp = (long)mid*mid;
			if(temp>x){
				high = mid-1;
			}else if(temp<x){
				low=mid+1;
			}else{
				return mid;
			}
		}

		return low-1;
    }

	public static void main(String args[]){
		MySqrt mySqrt = new MySqrt();
		System.out.println(mySqrt.mySqrt(2147395599));
	}
}
