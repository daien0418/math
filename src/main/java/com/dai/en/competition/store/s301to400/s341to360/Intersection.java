package com.dai.en.competition.store.s301to400.s341to360;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Intersection {

	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<Integer>();

		if (nums1 != null && nums2 != null && nums1.length != 0 && nums2.length != 0) {
			for (int i = 0; i < nums1.length; i++) {
				int size = set.size();
				if(size>=nums1.length||size>=nums2.length){
					break;
				}
				 for(int j=0;j<nums2.length;j++){
					 if(nums1[i]==nums2[j]){
						 set.add(nums1[i]);
						 break;
					 }
				 }
			}
		}

		int[] result = new int[set.size()];
		Iterator<Integer> iterator = set.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			result[i++] = iterator.next();
		}

		return result;
	}

	public static void main(String[] args) {

	}

}
