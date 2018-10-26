package competition.store.q1to100.q21to40;

public class StrStr {
	public int strStr(String haystack, String needle) {
        if(needle.equals("")) return 0;
        if(needle.length()>haystack.length()) return -1;
        int i=0,j=0;
        while(i<haystack.length()-needle.length()+1){
        	j=0;
        	while(j<needle.length()){
        		if(haystack.charAt(j+i)!=needle.charAt(j)){
        			break;
        		}
        		j++;
        	}
        	if(j==needle.length()) return i;
        	i++;
        }

        return -1;
    }
}
