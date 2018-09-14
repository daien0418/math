package competition.store.q61to80;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exist {

	public boolean exist(char[][] board, String word) {
		int m = board.length;
		int n = board[0].length;
		Map<Point, Integer> map = new HashMap<Point, Integer>();

		char[] words = word.toCharArray();
		int cIndex = 0;
		char cChar = words[0];

		List<Point> list = new ArrayList<Point>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == cChar) {
					list.add(new Point(i, j));
				}
			}
		}

		for (Point p : list) {
			List<List<Point>> l = new ArrayList<List<Point>>();
			List<Point> nList = new ArrayList<Point>();
			nList.add(p);
			l.add(nList);

			cIndex = 1;
			// map.clear();
			// map.put(p, 0);

			while (true) {
				if (cIndex >= words.length) {
					return true;
				}
				List<List<Point>> newList = new ArrayList<List<Point>>();
				for (int i = 0; i < l.size(); i++) {
					List<Point> nL = l.get(i);
					Point point = nL.get(nL.size() - 1);

					if (point.x + 1 <= m - 1) {
						if (board[point.x + 1][point.y] == words[cIndex]
								&& !nL.contains(new Point(point.x + 1, point.y))) {
							Point nPoint = new Point(point.x + 1, point.y);
							List<Point> nnL = new ArrayList<Point>(nL);
							nnL.add(nPoint);
							newList.add(nnL);
						}
					}
					if (point.x - 1 >= 0) {
						if (board[point.x - 1][point.y] == words[cIndex]
								&& !nL.contains(new Point(point.x - 1, point.y))) {
							Point nPoint = new Point(point.x - 1, point.y);
							List<Point> nnL = new ArrayList<Point>(nL);
							nnL.add(nPoint);
							newList.add(nnL);
						}
					}
					if (point.y - 1 >= 0) {
						if (board[point.x][point.y - 1] == words[cIndex]
								&& !nL.contains(new Point(point.x, point.y - 1))) {
							Point nPoint = new Point(point.x, point.y - 1);
							List<Point> nnL = new ArrayList<Point>(nL);
							nnL.add(nPoint);
							newList.add(nnL);
						}
					}
					if (point.y + 1 <= n - 1) {
						if (board[point.x][point.y + 1] == words[cIndex]
								&& !nL.contains(new Point(point.x, point.y + 1))) {
							Point nPoint = new Point(point.x, point.y + 1);
							List<Point> nnL = new ArrayList<Point>(nL);
							nnL.add(nPoint);
							newList.add(nnL);
						}
					}
				}

				if (newList.size() == 0) {
					break;
				}

				l.clear();
				l.addAll(newList);
				cIndex++;
			}

		}

		return false;
	}

	public static void main(String[] args) {
		Exist exist = new Exist();
		char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'E', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABCESEEEFS";
		System.out.println(exist.exist(board, word));
	}

	class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			return 100 * x + y;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

	}
}
