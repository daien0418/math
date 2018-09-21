package competition.store.q61to80;

public class Exist {

	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || board.length * board[0].length < word.length())
			return false;

		boolean[][] mark = new boolean[board.length][board[0].length];
		boolean res = false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0))
					res = findWord(board, word, 0, i, j, mark);
				if (res)
					return true;
			}
		}

		return false;
	}

	public boolean findWord(char[][] board, String word, int wordIndex, int row, int col, boolean[][] markBoard) {
		if (wordIndex == word.length())
			return true;
		if (row >= board.length || row < 0 || col >= board[0].length || col < 0
				|| word.charAt(wordIndex) != board[row][col] || markBoard[row][col])
			return false;

		markBoard[row][col] = true;

		if (findWord(board, word, wordIndex + 1, row - 1, col, markBoard)
				|| findWord(board, word, wordIndex + 1, row, col + 1, markBoard)
				|| findWord(board, word, wordIndex + 1, row + 1, col, markBoard)
				|| findWord(board, word, wordIndex + 1, row, col - 1, markBoard)) {
			return true;
		}

		markBoard[row][col] = false;//ÊÍ·Å±ê¼Ç

		return false;
	}

	public static void main(String[] args) {
		Exist exist = new Exist();
		char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'E', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABCESEEEFS";
		System.out.println(exist.exist(board, word));
	}

}
