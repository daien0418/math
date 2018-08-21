package competition.store.q61to80;

public class RemoveDuplicates {
	public int removeDuplicates(int[] nums) {
        int val = -1;
        int num = 0;
        int off=0;
        int index = 0;
        int j=0;
        
        while(index+off<nums.length)
        {
            if(val==nums[index]){
                if(num==2){
                    for(j=index;j<nums.length-off-1;j++){
                        nums[j]=nums[j+1];
                    }
                    off++;
                    index--;
                }else{
                    num ++;
                }
            }else{
               val = nums[index];
               num=1;
            }
            index++;
        }
        
        return nums.length - off;
    }
	
	public static void main(String[] args) {
		RemoveDuplicates removeDuplicates = new RemoveDuplicates();
		int[] nums =new int[]{1,1,1,2,2,3};
		System.out.print(removeDuplicates.removeDuplicates(nums));
		
	}
}
