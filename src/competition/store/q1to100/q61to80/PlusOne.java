package competition.store.q1to100.q61to80;

public class PlusOne {

	public int[] plusOne(int[] digits) {

		int tail = 0;
		int i = digits.length-1;
		while(i>=0){
			tail = digits[i];
			if(tail!=9){
				digits[i] = digits[i]+1;
				break;
			}else{
				digits[i] = 0;
				i--;
			}
		}

		if(i!=-1){
			return digits;
		}

		int[] ret = new int[digits.length+1];
		ret[0]= 1;
		for( i=0;i<digits.length;i++){
			ret[i+1]=digits[i];
		}
		return ret;
    }

	public static void main(String[] args) {
		PlusOne plusOne = new PlusOne();
		int[] digits =new int[]{9,8,7,6,5,4,3,2,1,0};
		for(int a:plusOne.plusOne(digits)){
			System.err.print(a);
		}
	}

}
