package competition.store.q21to40;

public class RemoveElement {
	public int removeElement(int[] nums, int val) {
		int times = 0;
        for(int i=nums.length-1;i>=0;i--){
        	if(nums[i]==val){
        		for(int j=i;j<nums.length-1-times;j++){
        			nums[j]=nums[j+1];
        		}
        		times++;
        	}
        }
        return nums.length - times;
    }
}
