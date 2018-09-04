package competition.contest100;

public class IsMonotonic {

	public boolean isMonotonic(int[] A) {
		boolean up = true;
		boolean down = true;

		for(int i=0;i<A.length-1;i++){
			if(A[i]<A[i+1]){
				up = up && true;
				down = down && false;
			}
			if(A[i]>A[i+1]){
				up = up && false;
				down = down && true;
			}
		}

		return up||down;
	}

	public static void main(String[] args) {

	}

}
