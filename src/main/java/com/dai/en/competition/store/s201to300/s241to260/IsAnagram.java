package com.dai.en.competition.store.s201to300.s241to260;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IsAnagram {

	public boolean isAnagram(String s, String t) {
		if (s == null || t == null)
			return false;
		if (s.length() != t.length())
			return false;
		Map<Character, Integer> sMap = new HashMap<Character, Integer>();
		// Map<Character, Integer> tMap = new HashMap<Character, Integer>();

		for (char c : s.toCharArray()) {
			if (sMap.containsKey(c)) {
				sMap.put(c, sMap.get(c) + 1);
			} else {
				sMap.put(c, 1);
			}
		}

		for (char c : t.toCharArray()) {
			if (!sMap.containsKey(c)) {
				return false;
			} else {
				sMap.put(c, sMap.get(c) - 1);
			}
		}

		Iterator<Character> iterator = sMap.keySet().iterator();

		while (iterator.hasNext()) {
			if (sMap.get(iterator.next()) != 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {

	}

}
