package competition.store.q1to100.q21to40;

import java.util.HashSet;
import java.util.Set;

public class IsValidSudoku {

	public boolean isValidSudoku(char[][] board) {
		Set[][] sets = new Set[3][3];
		sets[0][0] = new HashSet<Character>();
		sets[0][1] = new HashSet<Character>();
		sets[0][2] = new HashSet<Character>();
		sets[1][0] = new HashSet<Character>();
		sets[1][1] = new HashSet<Character>();
		sets[1][2] = new HashSet<Character>();
		sets[2][0] = new HashSet<Character>();
		sets[2][1] = new HashSet<Character>();
		sets[2][2] = new HashSet<Character>();

		char cur=0;
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				cur =board[i][j];
				if(cur=='.') continue;
				for(int m=0;m<9;m++){
					for(int n=0;n<9;n++){
						if((i==m&&j==n)||(i!=m&&j!=n)){
							continue;
						}
						if(board[m][n]=='.') continue;
						if(board[m][n]==cur) return false;
					}
				}
				Set curSet = sets[i/3][j/3];
				if(curSet.contains(cur)){
					return false;
				}else{
					curSet.add(cur);
				}
			}
		}

		return true;
    }

	public static void main(String[] args) {

	}

}
