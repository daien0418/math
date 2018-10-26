package competition.store.q1to100.q1to20;

public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
        int ret =0;
        int min=Integer.MAX_VALUE;

        for(int i=0;i<nums.length-2;i++){
        	for(int j=i+1;j<nums.length-1;j++){
        		for(int k=j+1;k<nums.length;k++){
        			if(Math.abs(nums[i]+nums[j]+nums[k]-target)<min){
        				min=Math.abs(nums[i]+nums[j]+nums[k]-target);
        				ret = nums[i]+nums[j]+nums[k];
        			}
        		}
        	}
        }

        return ret;
    }
}
