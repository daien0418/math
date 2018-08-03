package competition.contest95;

public class NthMagicalNumber {

	private int maxGongYin(int A,int B){
		int ret=0;
		int number =  Math.min(A, B);
		for(int i=number;;i--){
			if(A%i==0&&B%i==0){
				ret=i;
				break;
			}
		}

		return ret;
	}

	public static void main(String args[]){
		NthMagicalNumber nthMagicalNumber = new NthMagicalNumber();
		System.out.println(nthMagicalNumber.nth(206117388, 938, 24479));
	}

	public int nth(int N, int A,int B){
		long min=Math.min(A, B);

		if(A%B==0||B%A==0){
			return (int)(1l*N*min%(Math.pow(10, 9)+7l));
		}else{
			if(N==1)
				return (int)min;
			int maxgongyin=maxGongYin(A,B);
			return (int)(1l*cal(N, A/maxgongyin, B/maxgongyin)*maxgongyin%(Math.pow(10, 9)+7l));
		}
	}

	private long cal(int N,int A,int B){
		long ret=0l;
		long min=Math.min(A, B);
		long max=Math.max(A, B);
		int more=0;//
		int times=0;
		for(long i=min*(N*max/(min+max));;i=i+min){
			more=(int)(i/(A*B));
			times=(int)(i/min+i/max-more);
			if(times==N){
				ret = i;
				break;
			}else if(times>N){
				for(long m=i;;m--){
					if(m%max==0){
						ret=m;
						return ret;
					}
				}
			}
		}
		return ret;
	}
}
