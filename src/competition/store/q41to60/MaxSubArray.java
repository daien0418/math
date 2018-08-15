package competition.store.q41to60;

public class MaxSubArray {

	public int maxSubArray(int[] nums) {
		int max = nums[0];
		int sum = nums[0];

		for(int i=1;i<nums.length;i++){
			if(sum>0){
				sum =sum+nums[i];
			}else{
				sum = nums[i];
			}

			if(sum>max){
				max = sum;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		MaxSubArray maxSubArray = new MaxSubArray();
		System.out.println(maxSubArray.maxSubArray(new int[]{8,-19,5,-4,20}));

	}

}
