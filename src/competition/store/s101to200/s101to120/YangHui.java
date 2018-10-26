package competition.store.s101to200.s101to120;

import java.util.ArrayList;
import java.util.List;

public class YangHui {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		for (int i = 0; i < numRows; i++) {
			List<Integer> newList = new ArrayList<Integer>(i + 1);

			for (int j = 0; j < i + 1; j++) {
				if (j == 0 || j == i) {
					newList.add(j, 1);
				} else {
					newList.add(j, list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
				}
			}

			list.add(newList);
		}

		return list;
	}

	public static void main(String[] args) {
		YangHui yangHui = new YangHui();
		yangHui.generate(8);
	}
}
