package com.dai.en.competition.store.q1to100.q21to40;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<>();
		help(list, temp, candidates, target, 0);
		return list;
	}

	private void help(List<List<Integer>> result, List<Integer> temp, int[] candidates, int target, int n) {

		if (target == 0) {
			result.add(new ArrayList<>(temp));
			return;
		}
		if (target < 0) {
			return;
		}

		for (int i = n; i < candidates.length; i++) {
			target = target - candidates[i];
			temp.add(candidates[i]);
			help(result, temp, candidates, target, n++);
			temp.remove(temp.size() - 1);
			target = target + candidates[i];
		}

	}

	public static void main(String[] args) {
		CombinationSum combinationSum = new CombinationSum();
		List<List<Integer>> retList = combinationSum.combinationSum(new int[] { 2, 3, 5 }, 10);
		for (List<Integer> list : retList) {
			for (int i : list) {
				System.out.print(i);
				System.out.print(",");
			}
			System.out.println("");
		}
	}

}
