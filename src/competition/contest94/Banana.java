package competition.contest94;

public class Banana {
	public int minEatingSpeed(int[] piles, int H) {
		long sum=0;
		for(int i=0;i<piles.length;i++){
			sum=sum+piles[i];
		}

		int ret = (int)(sum/H);

		while (true) {
			long temp = 0;
			for (int i = 0; i < piles.length; i++) {
				temp = temp + (long) Math.ceil((double)piles[i]/ret);
			}
			if (temp <= H)
				break;
			ret++;
		}

		return ret;
	}

	public static void main(String args[]){
		Banana banana = new Banana();
		int ret = banana.minEatingSpeed(new int[]{332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184
				}, 823855818);
		System.out.println(ret);
	}
}
