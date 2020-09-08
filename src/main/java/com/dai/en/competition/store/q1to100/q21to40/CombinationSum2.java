package com.dai.en.competition.store.q1to100.q21to40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<>();
		Arrays.sort(candidates);
		help(list, temp, candidates, target, 0);
		return list;
	}

	private void help(List<List<Integer>> result, List<Integer> temp, int[] candidates, int target, int n) {

		if (target == 0 && !result.contains(temp)) {
			result.add(new ArrayList<>(temp));
			return;
		}
		if (target < 0) {
			return;
		}

		for (int i = n; i < candidates.length; i++) {
			target = target - candidates[i];
			temp.add(candidates[i]);
			n++;
			help(result, temp, candidates, target, n);
			temp.remove(temp.size() - 1);
			target = target + candidates[i];
		}

	}

	public static void main(String[] args) {
		CombinationSum2 combinationSum2 = new CombinationSum2();
		List<List<Integer>> retList = combinationSum2.combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8);
		for (List<Integer> list : retList) {
			for (int i : list) {
				System.out.print(i);
				System.out.print(",");
			}
			System.out.println("");
		}
	}

}
