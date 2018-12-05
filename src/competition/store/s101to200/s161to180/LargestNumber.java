package competition.store.s101to200.s161to180;

public class LargestNumber {

	public String largestNumber(int[] nums) {
		for (int i = nums.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (compare(nums[j], nums[j + 1]) < 0L) {
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
			}
		}

		StringBuilder stringBuilder = new StringBuilder();
		for (int n : nums) {
			stringBuilder.append(n);
		}
		String result = stringBuilder.toString();
		if (result.split("0").length == 0) {
			return "0";
		}
		return result;
	}

	private long compare(int a, int b) {
		long first = Long.parseLong(String.valueOf(a) + String.valueOf(b));
		long second = Long.parseLong(String.valueOf(b) + String.valueOf(a));

		return first - second;
	}

	public static void main(String[] args) {
	}

}
