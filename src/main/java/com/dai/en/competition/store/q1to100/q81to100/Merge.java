package com.dai.en.competition.store.q1to100.q81to100;

public class Merge {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int temp=0;
		int cur=0;
		int last = 0;
		int max = m-1;
		boolean find = false;
		for(int i=0;i<n;i++){
			find = false;
			int j;
			for(j=last;j<=max;j++){
				if(nums1[j]>nums2[i]){
					cur = nums1[j];
					int k = j;
					while(k+1<nums1.length&&k<=max){
						temp = nums1[k+1] ;
						nums1[k+1] = cur;
						cur = temp;
						k++;
					}
					max = k;
					nums1[j]=nums2[i];
					last = j+1;
					find = true;
					break;
				}
			}
			if(!find){
				nums1[m+i]=nums2[i];
				last = m+i +1;
			}
		}
    }

	public static void main(String[] args) {
		Merge merge = new Merge();
		int[] nums1 = new int[]{0,0,3,0,0,0,0,0,0};
		int[] nums2 = new int[]{-1,1,1,1,2,3};
		merge.merge(nums1, 3, nums2, 6);
		for(int a:nums1){
			System.out.print(a);
		}
	}
}
