package competition.store.s141to160;

import java.util.ArrayList;
import java.util.List;

public class MinStack {

	List<Integer> list = new ArrayList<Integer>();
	List<Integer> minValueList = new ArrayList<Integer>();

	public MinStack() {

	}

	public void push(int x) {
		list.add(0, x);
		if (minValueList.size() == 0) {
			minValueList.add(x);
		} else {
			if (x > minValueList.get(0)) {
				minValueList.add(0, minValueList.get(0));
			} else {
				minValueList.add(0, x);
			}
		}
	}

	public void pop() {
		list.remove(0);
		minValueList.remove(0);
	}

	public int top() {
		return list.get(0);
	}

	public int getMin() {
		return minValueList.get(0);
	}

	public static void main(String[] args) {

	}

}
