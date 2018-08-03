public class HeapSort {

	public int[] sort(int[] data) {
		init(data);

		for (int i = data.length - 1; i > 0; i--) {
			int temp = data[0];
			data[0] = data[i];
			data[i] = temp;
			treefly(data, 0, i);
		}
		return data;
	}

	public void init(int[] data) {
		for (int i = data.length / 2 - 1; i >= 0; i--) {
			treefly(data, i, data.length);
		}
	}

	public void treefly(int[] data, int index, int size) {
		//µÝ¹é
		// int left = 2 * index + 1;
		// int right = 2 * index + 2;
		// int max = index;
		// if(left<size&&data[left]>data[index]){
		// max = left;
		// }
		//
		// if(right<size&&data[right]>data[max]){
		// max = right;
		// }
		//
		// if(max!=index){
		// int temp = data[index];
		// data[index] = data[max];
		// data[max] = temp;
		// treefly(data, max, size);
		// }

		//·ÇµÝ¹é
		int left;
		int right;
		int max;
		boolean flag = true;
		while (flag) {
			max = index;
			left = 2 * index + 1;
			right = 2 * index + 2;
			if (left < size && data[left] > data[index]) {
				max = left;
			}

			if (right < size && data[right] > data[max]) {
				max = right;
			}
			if (max != index) {
				int temp = data[index];
				data[index] = data[max];
				data[max] = temp;
				flag = true;
				index = max;
			} else {
				flag = false;
			}
		}
	}

	public static void main(String args[]) {
		int[] data = new int[] { 16, 5, 7, 10, 13, 2, 5, 4, 1 };
		for (int val : data) {
			System.out.print(val + ",");
		}
		HeapSort heapSort = new HeapSort();
		data = heapSort.sort(data);
		System.out.println();
		for (int val : data) {
			System.out.print(val + ",");
		}
	}
}
