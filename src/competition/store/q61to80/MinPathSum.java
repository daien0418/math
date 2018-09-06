package competition.store.q61to80;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinPathSum {

	public int minPathSum2(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		return min(m-1, n-1, grid);
	}

	private int min(int x, int y, int[][] grid) {
		int min = Integer.MAX_VALUE;
		if (x == 0 && y == 0) {
			min = 0;
		}

		if (x > 0) {
			min = Math.min(min, min(x - 1, y, grid));
		}
		if (y > 0) {
			min = Math.min(min, min(x, y - 1, grid));
		}

		return grid[x][y] + min;
	}

	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		List<List<Point>> list = new ArrayList<List<Point>>();
		List<Point> nList = new ArrayList<Point>();
		Point point = new Point();
		point.x = 0;
		point.y = 0;
		nList.add(point);
		list.add(nList);

		Map<Point, Integer> map = new HashMap<Point,Integer>();
		map.put(point, grid[0][0]);

		boolean over = false;
		while (true) {
			int size = list.size();
			for (int i = 0; i < size; i++) {
				List<Point> l = list.get(0);
				Point p = l.get(l.size() - 1);
				if (p.x == m - 1 && p.y == n - 1) {
					over = true;
					break;
				}
				if (p.x < m - 1) {
					Point nPoint = new Point();
					nPoint.x = p.x + 1;
					nPoint.y = p.y;

					if(map.containsKey(nPoint)){

					}else{
						map.put(nPoint, map.get(p)+grid[nPoint.x][nPoint.y]);
						List<Point> nl = new ArrayList<Point>();
						nl.addAll(l);
						nl.add(nPoint);
						list.add(nl);
					}

				}

				if (p.y < n - 1) {
					Point nPoint = new Point();
					nPoint.x = p.x;
					nPoint.y = p.y + 1;
					List<Point> nl = new ArrayList<Point>();
					nl.addAll(l);
					nl.add(nPoint);
					list.add(nl);
				}
				list.remove(0);
			}

			if (over) {
				break;
			}
		}

		int ret = Integer.MAX_VALUE;
		for (List<Point> l : list) {
			int sum = 0;
			for (Point p : l) {
				sum = sum + grid[p.x][p.y];
			}
			if (sum < ret) {
				ret = sum;
			}
		}

		return ret;
	}

	public static void main(String[] args) {
		MinPathSum minPathSum = new MinPathSum();
		int[][] min = new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		System.out.println(minPathSum.minPathSum2(min));
	}

	class Point {
		int x;
		int y;
	}
}
