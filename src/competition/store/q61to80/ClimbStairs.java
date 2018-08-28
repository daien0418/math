package competition.store.q61to80;

import java.util.ArrayList;
import java.util.List;

public class ClimbStairs {

	public int climbStairs(int n) {
		List<String> list = new ArrayList<String>();
		list.add(new String(""));

		for (int i = 1; i <= n; i++) {
			int size = list.size();
			for (int j = 0; j < size; j++) {
				String str = list.get(0);
				for (int k = 0; k <= str.length(); k++) {
					String newStr = str.substring(0, k) + "1" + str.substring(k, str.length());
					if (!list.contains(newStr)) {
						list.add(newStr);
					}
				}
				list.remove(0);
			}
			if (i % 2 == 0) {
				String ful2 = new String("");
				for (int m = 0; m < i / 2; m++) {
					ful2 = ful2 + "2";
				}
				list.add(ful2);
			}
		}

		return list.size();
	}

	public static void main(String[] args) {
		ClimbStairs climbStairs = new ClimbStairs();
		System.out.println(climbStairs.climbStairs(5));
	}

}
