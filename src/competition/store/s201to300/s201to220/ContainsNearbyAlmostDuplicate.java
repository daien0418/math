package competition.store.s201to300.s201to220;

import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicate {

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null)
			return false;
		if (t < 0)
			return false;
		TreeSet<Long> set = new TreeSet<Long>();
		for (int i = 0; i < nums.length; i++) {
			if (set.size() >= k + 1) {
				set.remove((long) nums[i - k - 1]);
			}
			if (!set.subSet((long) nums[i] - t, true, (long) nums[i] + t, true).isEmpty()) {
				return true;
			}
			set.add((long) nums[i]);
		}

		return false;
	}

	public static void main(String[] args) {
		ContainsNearbyAlmostDuplicate containsNearbyAlmostDuplicate = new ContainsNearbyAlmostDuplicate();
		boolean result = containsNearbyAlmostDuplicate.containsNearbyAlmostDuplicate(new int[] { 2, 5, 8, 1, 4, 7 }, 2,
				2);
		System.out.println(result);
	}

}
