package competition.store.s101to200.s181to200;

import java.util.HashSet;
import java.util.Set;

public class Rotate {

	/**
	 * 超时
	 *
	 * @param nums
	 * @param k
	 */
	public void rotate(int[] nums, int k) {

		int last = 0;
		int temp = 0;

		k = k % nums.length;

		for (int i = 0; i < k; i++) {
			last = nums[nums.length - 1];
			for (int j = 0; j < nums.length; j++) {
				temp = nums[j];
				nums[j] = last;
				last = temp;
			}
		}

	}

	/**
	 * 空间复杂度不是1
	 *
	 * @param nums
	 * @param k
	 */
	public void rotate2(int[] nums, int k) {
		k = k % nums.length;
		Set<Integer> set = new HashSet<Integer>();

		int last = nums[0];
		int temp = 0;
		int index = 0;

		for (int i = 0; i < k; i++) {
			index = i;
			last = nums[i];
			while (true) {
				int nextIndex = (index + k) % nums.length;
				if (!set.contains(nextIndex)) {
					temp = nums[nextIndex];
					nums[nextIndex] = last;
					last = temp;
				} else {
					break;
				}
				set.add(nextIndex);
				index = nextIndex;
			}
		}
	}

	public void rotate3(int[] nums, int k) {
		k = k % nums.length;
		int last = nums[0];
		int temp = 0;
		int index = 0;
		int sum = 0;
		boolean circle = false;

		for (int i = 0; i < k; i++) {
			index = i;
			last = nums[i];
			circle = false;

			while (true) {
				int nextIndex = (index + k) % nums.length;
				if (circle) {
					if (i != index) {
						temp = nums[nextIndex];
						nums[nextIndex] = last;
						last = temp;
					} else {
						break;
					}
				} else {
					temp = nums[nextIndex];
					nums[nextIndex] = last;
					last = temp;
					circle = true;
				}
				index = nextIndex;
				sum++;
			}
			if (sum == nums.length) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		Rotate rotate = new Rotate();
		rotate.rotate3(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3);
	}

}
