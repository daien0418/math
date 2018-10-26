package competition.store.q1to100.q81to100;

public class NumTrees {
	public int numTrees(int n) {

		//*&**************动态规划
		int[] nums = new int[n + 1];
		nums[0] = 1;
		nums[1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= i - 1; j++) {
				nums[i] = nums[i] + nums[j] * nums[i - 1 - j];
			}
		}

		return nums[n];

		// return intSum(1, n);
	}

	/**
	 * 分治思想
	 *
	 * @param start
	 * @param end
	 * @return
	 */
	private int intSum(int start, int end) {
		if (start >= end)
			return 1;
		int sum = 0;
		int mid = (start + end) / 2;
		if ((end - start + 1) % 2 == 0) {
			for (int i = start; i <= mid; i++) {
				sum = sum + intSum(start, i - 1) * intSum(i + 1, end);
			}
			sum = sum * 2;
		} else {
			for (int i = start; i <= mid - 1; i++) {
				sum = sum + intSum(start, i - 1) * intSum(i + 1, end);
			}
			int half = intSum(start, mid - 1);
			sum = sum * 2 + half * half;
		}
		return sum;
	}

	public static void main(String[] args) {
		NumTrees numTrees = new NumTrees();
		System.out.println(numTrees.numTrees(4));
	}

}
