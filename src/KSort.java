public class KSort {

	public static int sort2(int[] data,int k){
		int max=Integer.MAX_VALUE;
		int temp=Integer.MIN_VALUE;
		for(int i=1;i<=k;i++){
			temp=Integer.MIN_VALUE;
			for(int j=0;j<data.length;j++){
				if(data[j]>temp&&data[j]<max)
					temp =data[j];
			}
			max=temp;
		}

		return temp;
	}

	public static void main(String args[]){
		int[] data = new int[]{3,1,4,2,7,8,9,10,12,15,17};
		System.out.println(sort2(data,2));
	}

}
