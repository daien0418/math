package com.dai.en.competition.store.q1to100.q61to80;

public class SortColors {

	public void sortColors(int[] nums) {
		if (nums == null || nums.length == 0)
			return;
//		int temp = 0;
//		int left = 0;
//		int right = nums.length - 1;
//
//		for (int i = 0;  i <= right; i++) {
//			if (nums[i] == 0) {
//				temp = nums[i];
//				nums[i] = nums[left];
//				nums[left] = temp;
//				left++;
//			} else if (nums[i] == 2) {
//				temp = nums[i];
//				nums[i] = nums[right];
//				nums[right] = temp;
//				right--;
//				i--;
//			}
//		}

		int i=-1,j=-1,k=-1;
		for(int m=0;m<nums.length;m++){
			if(nums[m]==0){
				nums[++k]=2;
				nums[++j]=1;
				nums[++i]=0;
			}else if(nums[m]==1){
				nums[++k]=2;
				nums[++j]=1;
			}else{
				nums[++k]=2;
			}
		}

	}

	public static void main(String[] args) {
		SortColors sortColors = new SortColors();
		int[] nums = new int[] { 1, 2, 2, 2, 2, 0, 0, 0, 1, 1 };
		sortColors.sortColors(nums);
		for (int n : nums) {
			System.out.print(n);
			System.out.print(",");
		}
	}

}
