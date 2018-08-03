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
}
