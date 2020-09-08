package com.dai.en.competition.store.s101to200.s121to140;

public class SingleNumber {

	public int singleNumber(int[] nums) {
		int ret = 0;

		for(int i=0;i<nums.length;i++){
			boolean find=true;
			for(int j=0;j<nums.length;j++){
				if(j==i){
					continue;
				}
				if(nums[j]==nums[i]){
					find=false;
					break;
				}
			}
			if(!find){
				continue;
			}else{
				ret = nums[i];
				break;
			}
		}

		return ret;
	}

	public static void main(String[] args) {
		SingleNumber singleNumber = new SingleNumber();
		System.out.println(singleNumber.singleNumber(new int[]{2,2,1}));
	}

}
