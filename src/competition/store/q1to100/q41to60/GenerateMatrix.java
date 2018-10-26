package competition.store.q1to100.q41to60;

public class GenerateMatrix {

	public int[][] generateMatrix(int n) {
		int[][] nums = new int[n][n];
		int[] directions = new int[] { 0, 1, 2, 3 };// 0:right
		int curDir = directions[0];
		int x = 0;
		int y = 0;

		for (int i = 1; i <= n * n; i++) {
			nums[x][y] = i;
			if (curDir == 0) {
				if (y == n - 1) {
					x = x + 1;
					curDir = (curDir + 1) % 4;
				} else {
					if (nums[x][y + 1] != 0) {
						x = x + 1;
						curDir = (curDir + 1) % 4;
					} else {
						y = y + 1;
					}
				}
			} else if (curDir == 1) {
				if (x == n - 1) {
					y = y - 1;
					curDir = (curDir + 1) % 4;
				} else {
					if (nums[x + 1][y] != 0) {
						y = y - 1;
						curDir = (curDir + 1) % 4;
					} else {
						x = x + 1;
					}
				}
			} else if (curDir == 2) {
				if (y == 0) {
					x = x - 1;
					curDir = (curDir + 1) % 4;
				} else {
					if (nums[x][y - 1] != 0) {
						x = x - 1;
						curDir = (curDir + 1) % 4;
					} else {
						y = y - 1;
					}
				}
			} else if (curDir == 3) {
				if (nums[x - 1][y] != 0) {
					y = y + 1;
					curDir = (curDir + 1) % 4;
				} else {
					x = x - 1;
				}
			}
		}

		return nums;
	}

	public static void main(String[] args) {
		GenerateMatrix generateMatrix = new GenerateMatrix();
		generateMatrix.generateMatrix(3);
	}

}
