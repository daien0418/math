package competition.store.q41to60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique {
	public List<List<Integer>> permuteUnique(int[] nums) {
		 List<List<Integer>> list =  new ArrayList<List<Integer>>();
		 Arrays.sort(nums);
		 for(int i=0;i<nums.length;i++){
	        	if(i==0){
	        		List<Integer> newList = new ArrayList<Integer>();
	        		newList.add(nums[i]);
	        		list.add(newList);
	        		continue;
	        	}
	        	int l = list.size();
	        	for(int j=0;j<l;j++){
	        		List<Integer> cur = list.get(0);
	        		for(int k=0;k<cur.size()+1;k++){
	        			if(k==cur.size()||cur.get(k)!=nums[i]){
	        				List<Integer> newList = new ArrayList<>(cur);
	        				newList.add(k, nums[i]);
	        				if(!list.contains(newList)){
	        					list.add(newList);
	        				}
	        			}
	        		}
	        		list.remove(0);
	        	}
	        }
		 return list;
    }

	public static void main(String args[]){
		PermuteUnique permute = new PermuteUnique();
		int[] nums = new int[]{1,1,2,2};
		System.out.println(permute.permuteUnique(nums));
	}
}
