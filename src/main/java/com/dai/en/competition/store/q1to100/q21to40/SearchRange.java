package com.dai.en.competition.store.q1to100.q21to40;

public class SearchRange {

	public int[] searchRange(int[] nums, int target) {
        int[] ret = new int[2];
        ret[0] =-1;
        ret[1] =-1;

        int i=0,j=nums.length-1;
        int mid=0;
        while(i<=j){
        	mid = (i+j)/2;
        	if(nums[mid]>target){
        		j=mid-1;
        		continue;
        	}else if(nums[mid]<target){
        		i=mid+1;
        		continue;
        	}else{
        		j=mid-1;
        		if(ret[0]==-1){
        			ret[0]=mid;
        			ret[1]=mid;
        		}else{
        			ret[0]=Math.min(ret[0], mid);
        		}
        	}
        }

        if(ret[0]!=-1){
        	i=0;
        	j=nums.length-1;
        	while(i<=j){
        		mid = (i+j)/2;
        		if(nums[mid]>target){
        			j=mid-1;
        			continue;
        		}else if(nums[mid]<target){
        			i=mid+1;
        			continue;
        		}else{
        			i=mid+1;
        			ret[1]=Math.max(ret[1], mid);
        		}
        	}
        }

        return ret;
    }

	public static void main(String[] args) {
		 SearchRange searchRange =new SearchRange();
		 int[] nums = new int[]{5,7,7,8,8,10};
		 for(int i:searchRange.searchRange(nums, 6)){
			 System.out.print(i);
		 }

	}

}
