package com.dai.en.competition.store.q1to100.q21to40;

public class Search {

	public int search(int[] nums, int target) {
        int k=-1;
        int i=0,j=nums.length-1,mid=0;
        while(i<=j){
        	mid = (i+j)/2;
        	if(mid==i||mid==j){
        		if(nums[i]>nums[j]){
        			k=i;
        		}
        		break;
        	}
        	if(nums[mid]<nums[i]){
        		j=mid;
        	}else if(nums[mid]>nums[j]){
        		i=mid;
        	}else if(nums[mid]>nums[i]&&nums[mid]<nums[j]){
        		break;
        	}
        }

        if(k!=-1){
        	if(target>nums[k]||target<nums[k+1]){
        		return -1;
        	}
        	if(nums[0]<=target){
        		i=0;
        		j=k;
        	}
        	if(nums[nums.length-1]>=target){
        		i=k+1;
        		j=nums.length-1;
        	}
        }else{
        	i=0;
        	j=nums.length-1;
        }

        while(i<=j){
        	mid =(i+j)/2;
        	if(nums[mid]>target){
        		j=mid-1;
        	}else if(nums[mid]<target){
        		i=mid+1;
        	}else{
        		return mid;
        	}
        }

        return -1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Search search = new Search();
		int[] nums = new int[]{3,1};
		System.out.print(search.search(nums, 1));
	}

}
