package competition.contest100;

import java.util.HashSet;
import java.util.Set;

public class SubarrayBitwiseORs {

	public int subarrayBitwiseORs(int[] A) {
		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> set2 = new HashSet<Integer>();
		for (int a : A) {
			Set<Integer> set3 = new HashSet<Integer>();
			set3.add(a);
			for (int b : set2) {
				set3.add(b | a);
			}
			set2 = set3;
			set.addAll(set3);
		}
		return set.size();
	}

	public static void main(String[] args) {
		SubarrayBitwiseORs subarrayBitwiseORs = new SubarrayBitwiseORs();
		System.out.println(subarrayBitwiseORs.subarrayBitwiseORs(new int[] { 1, 2, 4 }));
	}

}
