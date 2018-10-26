package competition.store.q1to100.q41to60;

import java.util.HashSet;
import java.util.Set;

public class Rotate {
	public void rotate(int[][] matrix) {
        int n= matrix[0].length;
        Set<String> set = new HashSet<String>();
        int row=0,col=0,val=0,temp=0;
        for(int i=0;i<n;i++){
        	for(int j=0;j<n;j++){
        		if(!set.contains(i+""+j)){
        			row=i;
        			col=j;
        			val = matrix[row][col];
        			for(int k=0;k<4;k++){
        				temp = matrix[col][n-1-row];
        				matrix[col][n-1-row] = val;
        				val =temp;
        				
        				set.add(col+""+(n-1-row));
        				temp=row;
        				row = col;
        				col =n-1-temp;
        			}
        		}
        	}
        }
    }
	
	public static void main(String args[]){
		Rotate rotate = new Rotate();
		int[][] matrix = new int[][]{{1,2,3}, {4,5,6},{7,8,9}};
		
		for(int[] r: matrix){
			System.out.println();
			for(int c :r){
				System.out.print(c);
			}
		}
		rotate.rotate(matrix);
		for(int[] r:matrix ){
			System.out.println();
			for(int c :r){
				System.out.print(c);
			}
		}
	}
}
