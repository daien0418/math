package competition.store;

public class MaxArea {
	public int maxArea(int[] height) {
        int ret=0;

        for(int i=0;i<height.length-1;i++){
        	for(int j=i+1;j<height.length;j++){
        		ret = Math.max(ret, (j-i)*Math.min(height[i], height[j]));
        	}
        }

        return ret;
    }
}
