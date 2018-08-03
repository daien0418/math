
public class BFS {

	int[][] map = new int[5][5];
	{
		map[3][4] = 1;
	}

	int[][] book = new int[5][5];
	int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	point[] queue = new point[26];

	public void bfs(int x, int y) {
		int head = 0;
		int tail = 0;
		int tx = 0;
		int ty = 0;
		queue[tail] = new point(x, y);
		tail++;
		book[x][y] = 1;
		boolean flag = false;
		while (tail > head) {
			x = queue[head].x;
			y = queue[head].y;

			for (int i = 0; i < 4; i++) {
				tx = x + direction[i][0];
				ty = y + direction[i][1];

				if (tx != -1 && ty != -1 && tx != 5 && ty != 5 && book[tx][ty] != 1) {
					book[tx][ty] = 1;
					queue[tail] = new point(tx, ty);
					queue[tail].step = queue[head].step + 1;
					tail++;
				}
				if (tx == 3 && ty == 4) {
					flag = true;
					break;
				}
			}

			if (flag) {
				 break;
			}
			head++;
		}
		System.out.println(queue[tail - 1].step);
		for (int i = 0; i < queue.length; i++) {
			if (queue[i] != null) {
				System.out.println("(" + queue[i].x + "," + queue[i].y + ")," + queue[i].step);
			}
		}
	}

	public static void main(String args[]) {
		BFS bfs = new BFS();
		bfs.bfs(0, 0);
	}
}

class point {
	int x;
	int y;
	int step;

	public point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
