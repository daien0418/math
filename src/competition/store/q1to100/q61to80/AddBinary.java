package competition.store.q1to100.q61to80;

public class AddBinary {

	public String addBinary(String a, String b) {
//		int len = Math.max(a.length(), b.length());
		String ret="0";
		while(!a.equals("")||!b.equals("")){
			int na = a.length()==0?0:Integer.parseInt(String.valueOf(a.charAt(a.length()-1)));
			int nb = b.length()==0?0:Integer.parseInt(String.valueOf(b.charAt(b.length()-1)));
			int nr = Integer.parseInt(ret.substring(0,1));

			ret = (na+nb+nr)%2+ret.substring(1,ret.length());
			ret = (na+nb+nr)/2+""+ret;
			a=a.length()==0?"":a.substring(0,a.length()-1);
			b=b.length()==0?"":b.substring(0,b.length()-1);
		}

		if(ret.substring(0, 1).equals("0")){
			ret = ret.substring(1,ret.length());
		}

		return ret;
	}

	public static void main(String[] args) {

	}

}
