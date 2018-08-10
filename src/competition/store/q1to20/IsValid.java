package competition.store.q1to20;

public class IsValid {
	public boolean isValid(String s) {

		if(s.length()%2==1) return false;
		int i=0;
		boolean find = false;
		while(s.length()!=0){
			char cur = s.charAt(i);
			int j=1;
			if(cur=='['){
				find = false;
				while(j<s.length()){
					char tail = s.charAt(j);
					if(tail=='['){
						i=j;
					}
					if(tail==']'){
						if((j-i)%2==1){
							s=s.substring(0, i)+s.substring(i+1, j)+s.substring(j+1,s.length());
							find =true;
							break;
						}else{
							return false;
						}
					}
					j++;
				}
				if(!find) return false;
			}else if(cur=='('){
				find = false;
				while(j<s.length()){
					char tail = s.charAt(j);
					if(tail=='('){
						i=j;
					}
					if(tail==')'){
						if((j-i)%2==1){
							s=s.substring(0, i)+s.substring(i+1, j)+s.substring(j+1,s.length());
							find =true;
							break;
						}else{
							return false;
						}
					}
					j++;
				}
				if(!find) return false;
			}else if(cur=='{'){
				find = false;
				while(j<s.length()){
					char tail = s.charAt(j);
					if(tail=='{'){
						i=j;
					}
					if(tail=='}'){
						if((j-i)%2==1){
							s=s.substring(0, i)+s.substring(i+1, j)+s.substring(j+1,s.length());
							find =true;
							break;
						}else{
							return false;
						}
					}
					j++;
				}
				if(!find) return false;
			}else{
				return false;
			}
			i=0;
		}

		return true;
    }

	public static void main(String args[]){
		IsValid isValid = new IsValid();
		String string = "[({(())}[()])]";
		System.out.println(isValid.isValid(string));
	}
}
