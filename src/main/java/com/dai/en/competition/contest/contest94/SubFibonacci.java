package com.dai.en.competition.contest.contest94;

public class SubFibonacci {
	public int lenLongestFibSubseq(int[] A) {
		int ret = 0;
		int x1 = 0, x2 = 0, temp = 0;
		int i = 0, j = 1;
		while (i < A.length - 2 && j < A.length - 1) {
			temp = 0;
			x1 = A[i];
			x2 = A[j];
			int k = j;
			for (; k < A.length; k++) {
				if (x1 + x2 == A[k]) {
					x1 = x2;
					x2 = A[k];
					temp++;
				} else if (x1 + x2 < A[k]) {
					break;
				}
			}
			ret = Math.max(ret, temp);
			if (j < A.length - 2){
				j++;
			}
			else{
				i++;
				j = i + 1;
			}
		}

		return ret>0?ret+2:0;
	}

	public static void main (String args[]){
		SubFibonacci subFibonacci = new SubFibonacci();
		int[] A = new int[]{1,2,3,4,5,6,7,8};
		System.out.println(subFibonacci.lenLongestFibSubseq(A));
	}
}
