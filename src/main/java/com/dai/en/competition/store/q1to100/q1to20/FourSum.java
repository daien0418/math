package com.dai.en.competition.store.q1to100.q1to20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list =  new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length-3;i++){
        	for(int j=i+1;j<nums.length-2;j++){
        		int k=j+1;
        		int m=nums.length-1;

        		while(k<m){
    				if(nums[i]+nums[j]+nums[k]+nums[m] == target){
    					List<Integer> nList = new ArrayList<>();
    					nList.add(nums[i]);
    					nList.add(nums[j]);
    					nList.add(nums[k]);
    					nList.add(nums[m]);
    					list.add(nList);

    					while(k<m&&nums[k]==nums[k+1]){
    						k++;
    					}
    					while(m>k&&nums[m]==nums[m-1]){
    						m--;
    					}
    					k++;
    				}else if(nums[i]+nums[j]+nums[k]+nums[m]<target){
    					k++;
    				}else{
    					m--;
    				}
    			}

        		while(j<nums.length-2&&nums[j]==nums[j+1]){
        			j++;
        		}
        	}

        	while(i<nums.length-3&&nums[i]==nums[i+1]){
        		i++;
        	}
        }

        return list;
    }

	public static void main(String[] args) {
		FourSum fourSum = new FourSum();
	}

}
