package com.dai.en.competition.contest.contest83;

import java.util.ArrayList;
import java.util.List;

public class LargeGroupPositions {
	public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        char[] chars = S.toCharArray();
        int head=0;
        char c = 0;
        for(int i=0;i<chars.length;i++){
        	if(i==0){
        		c=chars[i];
        		continue;
        	}
        	if(c!=chars[i]){
        		if(i-head>=3){
        			List<Integer> l = new ArrayList<>();
        			l.add(head);
        			l.add(i-1);
        			list.add(l);
        		}
        		head = i;
        		c=chars[i];
        	}
        }

        if(chars.length-head>=3){
        	List<Integer> l = new ArrayList<>();
			l.add(head);
			l.add(chars.length-1);
			list.add(l);
        }

        return list;
    }
}
