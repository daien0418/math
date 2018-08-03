public class QuickSort  {

	public int[] sort2(int[] target, int i, int j) {
		int left = i;
		int right = j;
		int flag = i;

		if (i > j) {
			return target;
		}
		while (i != j) {

			while (i < j && target[j] >= target[flag]) {
				j--;
			}

			while (i < j && target[i] <= target[flag]) {
				i++;
			}
			if (i < j) {
				int temp = target[i];
				target[i] = target[j];
				target[j] = temp;
			} else {
				int temp = target[j];
				target[j] = target[flag];
				target[flag] = temp;
			}
		}

		sort2(target, left, i - 1);
		sort2(target, i + 1, right);
		return target;

	}

	public static void main(String args[]) {
		QuickSort quickSort = new QuickSort();
		int[] target = { 6, 1, 2, 7, 9, 3, 4, 5, 10, 8 };
		target = quickSort.sort2(target, 0, 9);
		for (int i = 0; i < target.length; i++) {
			System.out.println(target[i] + ",");
		}
	}

}
