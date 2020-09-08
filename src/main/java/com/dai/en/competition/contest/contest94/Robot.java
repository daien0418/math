package com.dai.en.competition.contest.contest94;
import java.util.HashSet;
import java.util.Set;

public class Robot {

	int[][] array = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
	int direction=0;

	public int robotSim(int[] commands, int[][] obstacles) {
		Set<String> set = new HashSet<String>();
		for(int[] o:obstacles){
			set.add(o[0]+","+o[1]);
		}

        int x=0,y=0,ret=0;
        for(int i=0;i<commands.length;i++){
        	if(commands[i]==-1){
        		direction=(direction+1)%4;
        	}else if(commands[i]==-2){
        		direction=(direction+3)%4;
        	}else{
        		for(int j=0;j<commands[i];j++){
        			int xNext = x+array[direction][0];
        			int yNext = y+array[direction][1];
        			if(set.contains(xNext+","+yNext))
        				break;
        			x=xNext;
        			y=yNext;
        		}
        		ret=Math.max(ret, x*x+y*y);
        	}
        }
        return ret;
    }

}
