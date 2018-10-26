package competition.store.q1to100.q41to60;

public class Trap {

	public int trap(int[] height) {
		return seperate(height);
	}

	private int seperate(int[] height) {

		int index = 0;
		int val = Integer.MIN_VALUE;
		for (int i = 0; i < height.length; i++) {
			if (height[i] > val) {
				index = i;
				val = height[i];
			}
		}

		return getLeftRain(0, index, height) + getRightRain(index, height.length - 1, height);
	}

	private int getLeftRain(int left, int right, int[] height) {
		if (right - left <= 1) {
			return 0;
		}
		int index = 0;
		int val = Integer.MIN_VALUE;
		for (int i = left; i < right; i++) {
			if (height[i] > val) {
				index = i;
				val = height[i];
			}
		}

		int sum = val * (right - index - 1);
		for (int i = index + 1; i < right; i++) {
			sum = sum - height[i];
		}

		return sum + getLeftRain(left, index, height);
	}

	private int getRightRain(int left, int right, int[] height) {
		if (right - left <= 1) {
			return 0;
		}

		int index = 0;
		int val = Integer.MIN_VALUE;
		for (int i = left + 1; i <= right; i++) {
			if (height[i] > val) {
				index = i;
				val = height[i];
			}
		}

		int sum = val * (index - left - 1);
		for (int i = left + 1; i < index; i++) {
			sum = sum - height[i];
		}

		return sum + getRightRain(index, right, height);
	}

	public static void main(String[] args) {
		Trap trap = new Trap();
		int[] height = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(trap.trap(height));
	}

}
