package competition.store.q1to100.q61to80;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class UniquePaths {

	public long uniquePaths(int m, int n) {

		if (m <= 1 || n <= 1)
			return 1;

		Map<Point, Long> map = new HashMap<Point, Long>();
		Point start = new Point(1, 1);
		map.put(start, 1l);

		boolean over = false;

		while (true) {

			Set<Point> set = map.keySet();
			Map<Point, Long> nMap = new HashMap<Point, Long>();
			for (Point p : set) {

				if (p.x == m && p.y == n) {
					over = true;
					break;
				}

				if (p.x < m) {
					Point point = new Point(p.x + 1, p.y);
					if (nMap.containsKey(point)) {
						nMap.put(point, nMap.get(point) + map.get(p));
					} else {
						nMap.put(point, map.get(p));
					}
				}
				if (p.y < n) {
					Point point = new Point(p.x, p.y + 1);
					if (nMap.containsKey(point)) {
						nMap.put(point, nMap.get(point) + map.get(p));
					} else {
						nMap.put(point, map.get(p));
					}
				}
			}

			if (!over) {
				map.clear();
				map.putAll(nMap);
			} else {
				break;
			}
		}

		Set<Point> set = map.keySet();
		long sum = 0l;
		for (Point p : set) {
			sum = sum + map.get(p);
		}

		return sum;
	}

	public static void main(String[] args) {
		UniquePaths uniquePaths = new UniquePaths();
		System.out.println(uniquePaths.uniquePaths(12, 14));
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
