package competition.store.q1to100.q61to80;

public class SearchMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int lowx = 0;
		int lowy = 0;
		int highx = m - 1;
		int highy = n - 1;
		int midx = 0;
		int midy = 0;

		do {
			int temp = ((highx) * n + (highy + 1) + (lowx) * n + (lowy + 1)) / 2;
			if (temp % n == 0) {
				midx = temp / n - 1;
				midy = n - 1;
			} else {
				midx = temp / n;
				midy = temp % n - 1;
			}

			if (matrix[midx][midy] < target) {
				if (midy == n - 1) {
					lowx = midx + 1;
					lowy = 0;
				} else {
					lowx = midx;
					lowy = midy + 1;
				}
			} else if (matrix[midx][midy] > target) {
				if (midy == 0) {
					highx = midx - 1;
					highy = n - 1;
				} else {
					highx = midx;
					highy = midy - 1;
				}
			} else {
				return true;
			}
		} while (((lowx) * n + (lowy + 1) <= (highx) * n + (highy + 1)));

		return false;
	}

	public static void main(String[] args) {
		SearchMatrix searchMatrix = new SearchMatrix();
		int[][] matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		int target = 3;
		System.out.println(searchMatrix.searchMatrix(matrix, target));
	}

}
