package competition.store.q81to100;

import java.util.ArrayList;
import java.util.List;

public class MaximalRectangle {

	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int ret = 0;
		int m = matrix.length;
		int n = matrix[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					List<Integer> list = new ArrayList<Integer>();
					initList(list, i, j, m - 1, n - 1, matrix);
					int temp = calculate(list);
					if (temp > ret) {
						ret = temp;
					}
				}
			}
		}

		return ret;
	}

	private int calculate(List<Integer> list) {
		int max = 0;
		int size = list.size();
		for (int j = 0; j < size; j++) {
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) < min) {
					min = list.get(i);
				}
				int temp = (i + 1) * min;
				if (temp > max) {
					max = temp;
				}
			}
			list.remove(0);
		}
		return max;
	}

	private void initList(List<Integer> list, int row, int col, int rLim, int cLim, char[][] matrix) {
		int rNum = 0;
		int rIndex = row;
		while (rIndex <= rLim) {
			if (matrix[rIndex][col] == '1') {
				rIndex++;
				rNum++;
			} else {
				break;
			}
		}
		list.add(rNum);

		if (col + 1 <= cLim && matrix[row][col + 1] == '1') {
			initList(list, row, col + 1, rLim, cLim, matrix);
		}

	}

	public static void main(String[] args) {
		MaximalRectangle maximalRectangle = new MaximalRectangle();
		// char[][] matrix = new char[][] { { '0', '0', '0', '1', '0', '1', '1',
		// '1' },
		// { '0', '1', '1', '0', '0', '1', '0', '1' }, { '1', '0', '1', '1',
		// '1', '1', '0', '1' },
		// { '0', '0', '0', '1', '0', '0', '0', '0' }, { '0', '0', '1', '0',
		// '0', '0', '1', '0' },
		// { '1', '1', '1', '0', '0', '1', '1', '1' }, { '1', '0', '0', '1',
		// '1', '0', '0', '1' },
		// { '0', '1', '0', '0', '1', '1', '0', '0' }, { '1', '0', '0', '1',
		// '0', '0', '0', '0' } };
		// char[][] matrix = new char[][] { { '1', '0', '1', '0', '0' }, { '1',
		// '0', '1', '1', '1' },
		// { '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } };

		char[][] matrix = new char[][] { { '1', '1', '1', '1', '1', '1', '1', '1' },
				{ '1', '1', '1', '1', '1', '1', '1', '0' }, { '1', '1', '1', '1', '1', '1', '1', '0' },
				{ '1', '1', '1', '1', '1', '0', '0', '0' }, { '0', '1', '1', '1', '1', '0', '0', '0' } };
		System.out.println(maximalRectangle.maximalRectangle(matrix));
	}

}
