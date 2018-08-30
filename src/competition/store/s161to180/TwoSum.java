package competition.store.s161to180;

public class TwoSum {

	public int[] twoSum(int[] numbers, int target) {
		int[] indexArray = new int[2];
		int i=0;
		int j=1;

		while(i<j&&j<numbers.length){
			if(numbers[i]+numbers[j]<target){
				if(j==numbers.length-1){
					i=i+1;
					j=i+1;
				}else{
					j++;
				}
			}else if(numbers[i]+numbers[j]>target){
				i=i+1;
				j=i+1;
			}else{
				indexArray[0]=i+1;
				indexArray[1]=j+1;
				break;
			}
		}

		return indexArray;
	}

	public static void main(String[] args) {

	}

}
