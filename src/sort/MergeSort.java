package sort;

public class MergeSort {

	//µİ¹é
	public void sort(int[] data) {
		separate(data, 0, data.length - 1);
	}

	//·Çµİ¹é
	/**
	 * @param data
	 */
	public void sort2(int[] data) {
		int gap = 1;
		while (gap < data.length) {
			for (int i = 0; i < data.length; i = i + 2 * gap) {
				if (i + gap - 1 < data.length ) {
					if(i + 2 * gap - 1 < data.length){
						merge(data, i, i + gap - 1, i + 2 * gap - 1);
					}else{
						merge(data, i, i + gap - 1, data.length - 1);
					}
				}
			}
			gap = 2 * gap;
		}

		if (gap / 2 != data.length) {
			gap = gap / 2;
			merge(data, 0, gap - 1, data.length - 1);
		}
	}

	private void separate(int[] data, int start, int end) {
		if (start >= end)
			return;
		int middle = (start + end) / 2;
		separate(data, start, middle);
		separate(data, middle + 1, end);
		merge(data, start, middle, end);
	}

	private void merge(int[] data, int start, int middle, int end) {
		int[] tmp = new int[end - start + 1];
		int i = start;
		int j = middle + 1;
		int k = 0;
		while (i <= middle && j <= end) {
			if (data[i] <= data[j]) {
				tmp[k] = data[i];
				i++;
			} else {
				tmp[k] = data[j];
				j++;
			}
			k++;
		}
		if (i <= middle) {
			for (; i <= middle; i++) {
				tmp[k++] = data[i];
			}
		}
		if (j <= end) {
			for (; j <= end; j++) {
				tmp[k++] = data[j];
			}
		}

		for (k = 0, i = start; i <= end; i++, k++) {
			data[i] = tmp[k];
		}
	}

	public static void main(String args[]) {
		int[] data = new int[] { 1, 9, 2, 4, 7, 5, 6 };
		MergeSort mergeSort = new MergeSort();
		// mergeSort.sort(data);
		mergeSort.sort2(data);
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + ",");
		}
	}

}
