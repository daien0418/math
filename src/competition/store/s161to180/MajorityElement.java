package competition.store.s161to180;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

	public int majorityElement(int[] nums) {
		int times=nums.length/2;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();

		for(int i=0;i<nums.length;i++){
			if(map.containsKey(nums[i])){
				int existTimes =map.get(nums[i]);
				map.put(nums[i], existTimes+1);
				if(existTimes+1>times){
					return nums[i];
				}
			}else{
				map.put(nums[i], 1);
			}
		}

		return nums[nums.length/2];
	}

	public static void main(String[] args) {

	}

}
