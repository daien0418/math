package competition;

import java.util.HashMap;

public class IntToRoman {
	public String intToRoman(int num) {
		HashMap<Integer, String> map = new HashMap<Integer,String>();
		map.put(1, "I");
		map.put(5, "V");
		map.put(10, "X");
		map.put(50, "L");
		map.put(100, "C");
		map.put(500, "D");
		map.put(1000, "M");
		map.put(4, "IV");
		map.put(9, "IX");
		map.put(40, "XL");
		map.put(90, "XC");
		map.put(400, "CD");
		map.put(900, "CM");

        String ret="";
        int temp=1;
        int k=num;

        while(k>0){

        	temp=1;

        	while(k>=10){
        		k=k/10;
        		temp=temp*10;
        	}
        	if(temp==1)
        		temp=k;
        	ret=ret+map.get(temp);
        	num=num-temp;
        	k=num;
        }
        return ret;
    }

	private String cal(int number){
		String s="";

		if(number>=1000){
			for(int i=0;i<number/1000;i++){
				s=s+"M";
			}
		}else if(100<number&&number<1000){

		}

		return s;
	}
}
