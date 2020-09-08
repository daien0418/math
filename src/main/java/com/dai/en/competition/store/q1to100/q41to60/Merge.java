package com.dai.en.competition.store.q1to100.q41to60;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.dai.en.competition.structure.Interval;

public class Merge {

	public List<Interval> merge(List<Interval> intervals) {

		intervals.sort(new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				if (o1.start > o2.start) {
					return 1;
				} else if (o1.start < o2.start) {
					return -1;
				}
				return 0;
			}
		});

		List<Interval> list = new ArrayList<Interval>();
		Interval last = null;
		for (Interval interval : intervals) {
			if (last == null) {
				last = interval;
				continue;
			} else {
				if (last.end < interval.start) {
					list.add(last);
					last = interval;
				} else if (last.end < interval.end) {
					last = new Interval(last.start, interval.end);
				} else {
					continue;
				}
			}
		}

		if (last != null) {
			list.add(last);
		}

		return list;
	}

	public static void main(String[] args) {
		Merge merge = new Merge();
		List<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(1, 4));
		list.add(new Interval(0, 4));
		List<Interval> retList = merge.merge(list);
		for (Interval interval : retList) {
			System.out.print("[");
			System.out.print(interval.start);
			System.out.print(",");
			System.out.print(interval.end);
			System.out.print("]");
			System.out.print(",");
		}
	}

}
