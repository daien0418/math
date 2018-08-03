package competition.store;

public class ZTransfer {
	public String convert(String s, int numRows) {
		if(numRows==1)
			return s;
		if(s.length()<numRows)
			return s;
        char[] array= s.toCharArray();
        String ret="";
        int k=(numRows*2)-2;
        int temp=0;
        for(int i=0;i<numRows;i++){
        	temp=k-i*2;
        	temp=temp==0?k:temp;
        	ret = ret+array[i];
        	for(int j=i+temp;j<array.length;j=j+temp){
        		ret =ret+array[j];
        		temp=k-temp==0?temp:k-temp;
        	}
        }

        return ret;
    }
}
