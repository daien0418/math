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
	 * ���c��2�������ݣ���ֻ��һ��1
	 * ÿ��c&c-1����ʹc��һ��1
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
		byte d = 46;//d��e�ж��ٲ�ͬ��λ���������������1�ĸ���
		byte e = 35;
		byte f = (byte) (d^e);
		System.out.println("����"+c+"��"+find2(f)+"��1��");
	}
}
