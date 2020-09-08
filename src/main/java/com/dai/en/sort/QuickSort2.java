package com.dai.en.sort;

public class QuickSort2 {

	public void sort(int[] data, int low, int high) {
		int start = low;
		int end = high;
		int tmp = data[low];
		int index = low;
		while (low < high) {

			while (data[high] > tmp && low < high) {
				high--;
			}

			if (low == high)
				break;
			data[index] = data[high];
			index = high;

			while (data[low] < tmp && low < high) {
				low++;
			}

			if (low == high)
				break;
			data[index] = data[low];
			index = low;
		}
		data[low] = tmp;

		if(low != end){
			sort(data, low + 1, end);
		}
		if(low != start){
			sort(data, start, low - 1);
		}
	}

	public static void main(String args[]) {
		QuickSort2 insertSort = new QuickSort2();
		int[] newData = new int[] { 12, 8, 3, 65, 36, 89, 15, 9 };
		insertSort.sort(newData, 0, 7);
		for (int v : newData) {
			System.out.print(v + ",");
		}
	}
}
