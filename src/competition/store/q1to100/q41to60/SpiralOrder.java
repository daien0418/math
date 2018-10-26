package competition.store.q1to100.q41to60;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0) {
			return list;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int[] directions = new int[] { 0, 1, 2, 3 };
		int direct = directions[0];
		int x = 0;
		int y = 0;
		int circle = 0;
		int times = 0;

		while (list.size() != m * n) {
			list.add(matrix[x][y]);
			if (direct == 0) {
				if (y == n - 1 - circle) {
					x = x + 1;
					direct = (direct + 1) % 4;
					times++;
					if (times != 0 && times % 4 == 0) {
						circle++;
					}
				} else {
					y = y + 1;
				}
			} else if (direct == 1) {
				if (x == m - 1 - circle) {
					y = y - 1;
					direct = (direct + 1) % 4;
					times++;
					if (times != 0 && times % 4 == 0) {
						circle++;
					}
				} else {
					x = x + 1;
				}
			} else if (direct == 2) {
				if (y == 0 + circle) {
					x = x - 1;
					direct = (direct + 1) % 4;
					times++;
					if (times != 0 && times % 4 == 0) {
						circle++;
					}
				} else {
					y = y - 1;
				}
			} else {
				if (x == 1 + circle) {
					y = y + 1;
					direct = (direct + 1) % 4;
					times++;
					if (times != 0 && times % 4 == 0) {
						circle++;
					}
				} else {
					x = x - 1;
				}
			}
		}

		return list;
	}

	public static void main(String[] args) {
		SpiralOrder spiralOrder = new SpiralOrder();
		spiralOrder.spiralOrder(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } });
	}

}
