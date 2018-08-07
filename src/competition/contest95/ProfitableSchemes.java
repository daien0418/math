package competition.contest95;

public class ProfitableSchemes {

	int mo=1000000007;
	public int profitableSchemes(int G, int P, int[] group, int[] profit) {
		int n=group.length;
        int[][] f=new int[G+1][P+1];
        f[0][0]=1;
        for (int i=0;i<n;i++)
        {
            for (int j=G-group[i];j>=0;j--)
            {
                for (int k=0;k<=P;k++)
                {
                    int jj=j+group[i],kk=Math.min(k+profit[i],P);
                    f[jj][kk]=(f[jj][kk]+f[j][k])%mo;
                }
            }
        }
        int ans=0;
        for (int i=0;i<=G;i++) ans=(ans+f[i][P])%mo;
        return ans;
    }


	public int pro2(int G, int P, int[] group, int[] profit){
		int ret=0;
		int[][] array = new int[G+1][P+1];

		for(int i=0;i<group.length;i++){
//			array[group[i]][Math.min(profit[i], P)]=(array[group[i]][Math.min(profit[i], P)]+1)%mo;
			for(int j=G-group[i];j>0;j--){
				for(int k=0;k<=P;k++){
					int jj=group[i]+j;
					int kk = Math.min(k+profit[i], P);
					array[jj][kk] = (array[jj][kk] + array[j][k])%mo;
				}
			}
			if(group[i]<=G){
				array[group[i]][Math.min(profit[i], P)]=(array[group[i]][Math.min(profit[i], P)]+1)%mo;
			}
		}

		for(int m=1;m<=G;m++){
			ret = (ret + array[m][P])%mo;
		}

		return ret;
	}
}
