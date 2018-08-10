package competition.store.q1to20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list =  new ArrayList<List<Integer>>();
		Arrays.sort(nums);

		for(int i=0;i<nums.length-2;i++){
			int j=i+1;
			int k=nums.length-1;
			while(j<k){
				if(nums[i]+nums[j]+nums[k] == 0){
					List<Integer> nList = new ArrayList<>();
					nList.add(nums[i]);
					nList.add(nums[j]);
					nList.add(nums[k]);
					list.add(nList);

					while(j<nums.length-1&&nums[j]==nums[j+1]){
						j++;
					}
					while(k>0&&nums[k]==nums[k-1]){
						k--;
					}
					j++;
				}else if(nums[i]+nums[j]+nums[k]<0){
					j++;
				}else{
					k--;
				}
			}

			while(i<nums.length-2&&nums[i]==nums[i+1]){
				i++;
			}
        }

		return list;
    }

	public static void main(String args[]){
		ThreeSum threeSum = new ThreeSum();
		int[] nums = new int[]{-1,0,1,2,-1,-4};
		System.out.println(threeSum.threeSum(nums));
	}

}
