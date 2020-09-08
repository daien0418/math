package com.dai.en.competition.store.q1to100.q81to100;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

	public List<Integer> grayCode(int n) {
		int size = 1 << n;

		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			int grayCode = i ^ i >> 1;
			res.add(grayCode);
		}
		return res;
	}

	public static void main(String[] args) {
		GrayCode grayCode = new GrayCode();
		List<Integer> retList = grayCode.grayCode(4);
		for (Integer i : retList) {
			System.out.print(i);
			System.out.print(",");
		}
	}

}
