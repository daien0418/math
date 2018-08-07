package competition.store.q1to20;

public class IntToRoman {
	public String intToRoman(int num) {
		String ret ="";
		int y=0;
		String temp="";
		for(int i=10;num!=0;i*=10){
			y=num%i;
			num = num-y;
			if(i==10){
				if(y==4){
					ret = "IV" + ret;
					continue;
				}
				if(y==9){
					ret = "IX"+ret;
					continue;
				}
				if(y>=5){
					ret="V"+ret;
					y=y-5;
				}
				for(int j=0;j<y;j++){
					ret =ret+"I";
				}

			}else if(i==100){
				if(y==40){
					ret = "XL" + ret;
					continue;
				}
				if(y==90){
					ret = "XC"+ret;
					continue;
				}
				temp="";
				if(y>=50){
					temp="L";
					y=y-50;
				}
				for(int j=0;j<y;j+=10){
					temp = temp+"X";
				}
				ret = temp+ret;
			}else if(i==1000){
				if(y==400){
					ret = "CD" + ret;
					continue;
				}
				if(y==900){
					ret = "CM"+ret;
					continue;
				}
				temp="";
				if(y>=500){
					temp="D";
					y=y-500;
				}
				for(int j=0;j<y;j+=100){
					temp =temp+"C";
				}
				ret = temp+ret;
			}else if(i==10000){
				temp="";
				for(int j=0;j<y;j+=1000){
					temp =temp+"M";
				}
				ret = temp+ret;
			}
		}
        return ret;
    }

	public static void main(String args[]){
		IntToRoman intToRoman = new IntToRoman();
		int num =  1994;
		System.out.println(intToRoman.intToRoman(num));
	}

}
