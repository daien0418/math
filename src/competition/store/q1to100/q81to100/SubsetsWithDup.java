package competition.store.q1to100.q81to100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsWithDup {

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(new ArrayList<Integer>());
		Set<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < nums.length; i++) {
			int size = list.size();
			for (int j = 0; j < size; j++) {
				if (set.contains(nums[i])) {
					// ²éÖØ
					if (list.get(j).contains(nums[i])) {
						List<Integer> newList = new ArrayList<Integer>(list.get(j));
						newList.add(nums[i]);
						boolean repeat = false;
						for (int k = j + 1; k < size; k++) {
							 if (list.get(k).size() == newList.size()) {
								List<Integer> a = list.get(k);
								int sSize = newList.size();
								boolean same = true;
								for (int m = 0; m < sSize; m++) {
									if (!a.get(m).equals(newList.get(m))) {
										same = false;
										break;
									}
								}
								if (same) {
									repeat = true;
									break;
								}
							}
						}
						if (!repeat) {
							list.add(newList);
						}
					}
				} else {
					List<Integer> newList = new ArrayList<Integer>(list.get(j));
					newList.add(nums[i]);
					list.add(newList);
				}
			}
			set.add(nums[i]);
		}

		return list;
	}

	public static void main(String[] args) {
		SubsetsWithDup subsets = new SubsetsWithDup();
		int[] nums = new int[] {1,4,3,5,4,4,7,7,8,0};

		List<List<Integer>> list = subsets.subsetsWithDup(nums);
		System.out.println(list.size());
		for (List<Integer> l : list) {
			for (Integer i : l) {
				System.out.print(i);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

}
