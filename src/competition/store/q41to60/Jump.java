package competition.store.q41to60;

public class Jump {

	/**
	 * [2,3,1,1,4]
	 *
	 * @param nums
	 * @return
	 */
	public int jump(int[] nums) {
		int ret = 0;

		int lastIndex = nums.length - 1;
		int firstIndex = 0;

		int temp = 0;

		while (lastIndex > 0) {
			temp = 0;
			while (temp < lastIndex) {
				if (nums[temp] >= lastIndex - temp) {
					firstIndex = temp;
					break;
				}
				temp++;
			}
			ret++;
			lastIndex = firstIndex;
		}

		return ret;
	}

	public static void main(String[] args) {
		Jump jump = new Jump();
		int[] nums = new int[] { 2, 3, 1, 1, 4 };
		System.out.println(jump.jump(nums));
	}

}
