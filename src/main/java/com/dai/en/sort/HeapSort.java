package com.dai.en.sort;

import java.util.Iterator;
import java.util.PriorityQueue;

public class HeapSort {

    int[] data = null;

    public int[] sort(int[] data) {
        this.data = data;
        heapify();
        for (int i = this.data.length - 1; i > 0; i--) {
            int temp = this.data[0];
            this.data[0] = this.data[i];
            this.data[i] = temp;
            siftdown(0, i - 1);
        }
        return this.data;
    }

    private void heapify() {
        for (int i = (data.length >>> 1) - 1; i >= 0; i--) {
            siftdown(i, data.length);
        }
    }

    private void siftdown(int index, int length) {
        int flag = data[index];
        while (index < length >>> 1) {
            int temp = (index << 1) + 1;
            int left = data[temp];
            int right = data[temp + 1];
            temp = left > right ? temp : temp + 1;
            if (flag >= data[temp]) {
                break;
            }
            data[index] = data[temp];
            index = temp;
        }
        data[index] = flag;
    }

    public static void main(String args[]) {
        int[] data = new int[] { 16, 5, 7, 10, 13, 2, 5, 4, 1 };
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(10);

        for (int val : data) {
            System.out.print(val + ",");
            queue.add(val);
        }

        System.out.println();
        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ",");
        }

        HeapSort heapSort = new HeapSort();
        data = heapSort.sort(data);
        System.out.println();
        for (int val : data) {
            System.out.print(val + ",");
        }
    }
}
