package com.dai.en.competition.store.q1to100.q41to60;

import java.util.ArrayList;
import java.util.List;

import com.dai.en.competition.structure.Interval;

public class Insert {

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> list = new ArrayList<Interval>();
		boolean added = false;

		for (Interval interval : intervals) {
			if (interval.start > newInterval.end) {
				if (!added) {
					list.add(newInterval);
					added = true;
				}
				list.add(interval);
				continue;
			}

			if (interval.end < newInterval.start) {
				list.add(interval);
				continue;
			}

			if (interval.start >= newInterval.start && interval.start <= newInterval.end) {
				if (interval.end >= newInterval.start && interval.end <= newInterval.end) {
					continue;
				} else {
					newInterval = new Interval(newInterval.start, interval.end);
					continue;
				}
			} else if (interval.end >= newInterval.start && interval.end <= newInterval.end) {
				newInterval = new Interval(interval.start, newInterval.end);
				continue;
			} else {
				list.add(interval);
				added = true;
			}

		}

		if (!added) {
			list.add(newInterval);
		}

		return list;
	}

	public static void main(String[] args) {
		Insert insert = new Insert();
		List<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(1, 2));
		list.add(new Interval(3, 5));
		list.add(new Interval(6, 7));
		list.add(new Interval(8, 10));
		list.add(new Interval(12, 16));
		List<Interval> retList = insert.insert(list, new Interval(4, 8));
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
