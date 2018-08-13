package competition.store.q21to40;

public class Divide {

	public int divide(int dividend, int divisor) {
		if(divisor == 0){
			return -1;
		}

		int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

		long result = 0;

		while(dvs <= dvd){
			long tmp = dvs;
			long mul = 1;

			while(dvd >= (tmp << 1)){
				tmp <<= 1;
				mul <<= 1;
			}

			dvd -= tmp;

			result += mul;

		}

		 if(result*sign>Integer.MAX_VALUE) return Integer.MAX_VALUE;

		return (int)result*sign;
	}

	public static void main(String args[]){
		Divide divide = new Divide();
		System.out.println(divide.divide(-2147483648, 1));
	}

}
