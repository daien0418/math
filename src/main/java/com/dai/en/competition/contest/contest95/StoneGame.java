package com.dai.en.competition.contest.contest95;

public class StoneGame {
	public boolean stoneGame(int[] piles) {
		int head=0;
		int tail=piles.length-1;

		int alex=0;
		int li=0;

		int turn=0;

		while (head<=tail){
			if(turn==0){
				if(head==tail){
					alex=alex+piles[head];
					head++;
				}else{
					if(piles[head+1]+piles[tail]<piles[head]+piles[tail-1]){
						alex=alex+piles[head];
						head++;
					}else if(piles[head+1]+piles[tail]>piles[head]+piles[tail-1]){
						alex=alex+piles[tail];
						tail--;
					}else{
						if(piles[head]>piles[tail]){
							alex=alex+piles[head];
							head++;
						}else{
							alex=alex+piles[tail];
							tail--;
						}
					}
				}
			}else{
				if(head==tail){
					li=li+piles[tail];
					tail--;
				}else{
					if(piles[head+1]+piles[tail]<piles[head]+piles[tail-1]){
						li=li+piles[head];
						head++;
					}else if(piles[head+1]+piles[tail]>piles[head]+piles[tail-1]){
						li=li+piles[tail];
						tail--;
					}else{
						if(piles[head]>piles[tail]){
							li=li+piles[head];
							head++;
						}else{
							li=li+piles[tail];
							tail--;
						}
					}
				}
			}
			turn= (turn+1)%2;
		}

        return alex>=li;
    }

	public static void main (String args[]){
	}

}
