package com.dai.en.competition.store.q1to100.q41to60;

public class Multiply {

	public String multiply(String num1, String num2) {

		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}

		int[] nArray = new int[num1.length() + num2.length()];

		for (int i = 0; i < num1.length() + num2.length(); i++) {
			nArray[i] = 0;
		}

		for (int i = 0; i < num1.length(); i++) {
			for (int j = 0; j < num2.length(); j++) {
				int cheng = Integer.valueOf(String.valueOf(num1.charAt(i)));
				int bcheng = Integer.valueOf(String.valueOf(num2.charAt(j)));
				int index = num1.length() - 1 - i + num2.length() - 1 - j;
				int ret = cheng * bcheng;
				int added = nArray[index];
				ret = ret + added;
				if (ret >= 10) {
					nArray[index] = ret % 10;
					up(nArray, index + 1, ret / 10);
				} else {
					nArray[index] = ret % 10;
				}
			}
		}

		int flag = 0;
		if (nArray[nArray.length - 1] == 0) {
			flag = nArray.length - 1;
		} else {
			flag = nArray.length;
		}
		String str = "";
		for (int i = 0; i < flag; i++) {
			str = nArray[i] + str;
		}

		return str;
	}

	private void up(int[] array, int index, int val) {
		int temp = array[index];
		temp = temp + val;
		if (temp < 10) {
			array[index] = temp;
		} else {
			array[index] = temp % 10;
			up(array, index + 1, temp / 10);
		}
	}

	public static void main(String[] args) {
		Multiply multiply = new Multiply();
		System.out.println(multiply.multiply("456", "123"));
	}

}
