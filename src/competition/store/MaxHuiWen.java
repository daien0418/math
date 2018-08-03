package competition.store;

public class MaxHuiWen {
	public String longestPalindrome(String s) {
        String ret="";
//        for(int i=0,j=0;i<s.length()&&j<s.length();){
//        	if(match(s.substring(i, j+1))){
//    			if(j-i+1>ret.length()){
//    				ret = s.substring(i, j+1);
//    			}
//    		}
//        	j++;
//        	if(j==s.length()){
//        		i++;
//        		j=i;
//        	}
//        }

        char[] array =  s.toCharArray();
        int length= array.length;
        for(int i=length;i>0;i--){
        	for(int j=0,k=i+j-1;j<length&&k<length;j++,k=i+j-1){
        		if(match(array,j,k)){
        			ret = s.substring(j,k+1);
        			return ret;
        		}
        	}
        }



//        for(int i=0;i<array.length;i++){
//        	for(int j=i;j<array.length;j++){
//        		if(match(array,i,j)){
//        			if(j-i+1>ret.length()){
//        				ret = s.substring(i, j+1);
//        			}
//        		}
//        	}
//        }
        return ret;
    }

	private boolean match(char[] array,int start,int end){
		if(end-start<=0)
			return true;
		if(array[start]!=array[end])
			return false;
		return match(array,start+1,end-1);
	}

//	private boolean match(String s){
//		if(s.length()<=1)
//			return true;
//		if(s.charAt(0)!=s.charAt(s.length()-1))
//			return false;
//		return match(s.substring(1, s.length()-1));
//	}


	public static void main(String args[]){
		MaxHuiWen maxHuiWen = new MaxHuiWen();
		System.out.println(maxHuiWen.longestPalindrome("cbbd"));
	}
}
