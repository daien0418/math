package com.dai.en.sort;

public class InsertSort {

	public void sort(int[] data) {
		int length = data.length;
		int temp;
		for (int i = 1; i < length; i++) {
			temp = data[i];
			for(int j=i-1;j>=0;j--){
				if(temp>=data[j])
					break;
				data[j+1]=data[j];
				data[j]=temp;
			}
		}
	}

	public static void main(String args[]) {
		InsertSort insertSort = new InsertSort();
		int[] newData = new int[] { 12, 8, 3, 65, 36, 89, 15, 9 };
		insertSort.sort(newData);
		for(int v:newData){
			System.out.print(v+",");
		}
	}
}
