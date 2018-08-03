package competition;

public class Palindrome {
	public boolean isPalindrome(int x) {
		if(x<0)
			return false;
		if(x==0)
			return true;

		int ret = 0;
		int k=x;
		while(x>ret){
			ret=ret*10+x%10;
			x=x/10;
		}

        return k==ret||k==ret/10;
    }
}
