package competition.store.q1to100.q21to40;

public class RemoveDuplicates {
	public int removeDuplicates(int[] nums) {
		int i=0,j=0;
		int times =0 ;

		while(i<nums.length-times-1){
			j=i;
			while(j+1<nums.length-times&&nums[j]==nums[j+1]){
				j++;
			}
			if(j>i){
				for(int k=j+1;k<nums.length-times;k++){
					nums[k-(j-i)] = nums[k];
				}
				times=times+j-i;
			}
			i++;
		}
		return nums.length-times;
    }

	public static void main(String args[]){
		RemoveDuplicates removeDuplicates = new RemoveDuplicates();
		int[] nums = new int[]{1,1};
		System.out.println(removeDuplicates.removeDuplicates(nums));
		for(int i:nums){
			System.out.println(i);
		}
	}
}
