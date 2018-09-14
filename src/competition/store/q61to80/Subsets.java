package competition.store.q61to80;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(new ArrayList<Integer>());

		for (int i = 0; i < nums.length; i++) {
			int size = list.size();
			for (int j = 0; j < size; j++) {
				List<Integer> newList = new ArrayList<Integer>(list.get(j));
				newList.add(nums[i]);
				list.add(newList);
			}
		}

		return list;
	}

	public static void main(String[] args) {
		Subsets subsets = new Subsets();
		int[] nums = new int[]{1,2,3};

		List<List<Integer>> list = subsets.subsets(nums);

		for(List<Integer> l : list){
			for(Integer i : l){
				System.out.print(i);
				System.out.print(" ");
			}
			System.out.println();
		}

	}

}
