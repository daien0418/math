package com.dai.en.competition.store.q1to100.q61to80;

public class SetZeroes {

	public void setZeroes(int[][] matrix) {

	}

	public static void main(String[] args) {
		SetZeroes setZeroes = new SetZeroes();
		int[][] matrix = new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		setZeroes.setZeroes(matrix);

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]);
				System.out.print(",");
			}
			System.out.println("");
		}
	}

}
