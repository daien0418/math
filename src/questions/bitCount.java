package questions;

public class bitCount {

	public static int find(byte c){
		int sum=0;
		for(int i=0;i<8;i++){
			sum+=c&1;
			c>>=1;
		}

		return sum;
	}

	/**
	 * 如果c是2的整数幂，则只有一个1
	 * 每次c&c-1，会使c少一个1
	 *
	 * @param c
	 * @return
	 */
	public static int find2(byte c){
		int sum =0;
		while(c!=0){
			c&=c-1;
			sum++;
		}

		return sum;
	}

	public static void main(String args[]){
		byte c = 61;
		byte d = 46;//d与e有多少不同的位数，先求异或，再求1的个数
		byte e = 35;
		byte f = (byte) (d^e);
		System.out.println("数字"+c+"有"+find2(f)+"个1。");
	}
}
