package competition.store.q1to100.q81to100;

public class LargestRectangleArea {

	public int largestRectangleArea(int[] heights) {
		int max = 0;
		for (int i = 0; i < heights.length; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = i; j < heights.length; j++) {
				if (heights[j] < min) {
					min = heights[j];
				}
				int temp = (j - i + 1) * min;
				if (temp > max) {
					max = temp;
				}
			}
		}

		return max;
	}

	public static void main(String[] args) {
		LargestRectangleArea largestRectangleArea = new LargestRectangleArea();
		int[] heights = new int[] { 2, 1, 5, 6, 2, 3 };
		System.out.println(largestRectangleArea.largestRectangleArea(heights));
	}

}
