package com.dai.en.competition.store.q1to100.q41to60;

import java.util.ArrayList;
import java.util.List;

public class Permute {
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list =  new ArrayList<List<Integer>>();
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
        			List<Integer> newList = new ArrayList<>(cur);
        			newList.add(k, nums[i]);
        			list.add(newList);
        		}
        		list.remove(0);
        	}
        }
        return list;
    }

	public static void main(String args[]){
		Permute permute = new Permute();
		int[] nums = new int[]{1,2,3};
		System.out.println(permute.permute(nums));
	}
}
