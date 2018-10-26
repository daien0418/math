package competition.store.q1to100.q1to20;

public class RomanToInt {
	public int romanToInt(String s) {
        int ret =0;
        int last =Integer.MAX_VALUE;
        int cur = 0;
        for(int i=0;i<s.length();i++){
        	cur = get(String.valueOf(s.charAt(i)));
        	if(cur>last){
        		ret=ret-2*last + cur;
        	}else{
        		ret = ret+cur;
        	}
        	last = cur;
        }

        return ret;
    }

	private int get(String s){
		switch (s) {
		case "I":
			return 1;
		case "V":
			return 5;
		case "X":
			return 10;
		case "L":
			return 50;
		case "C":
			return 100;
		case "D":
			return 500;
		case "M":
			return 1000;
		default:
			return 0;
		}
	}

	public static void main(String args[]){
		RomanToInt romanToInt = new RomanToInt();
		String s = "MCMXCIV";
		System.out.println(romanToInt.romanToInt(s));
	}
}
