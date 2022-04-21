package googlejam6.p486;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;
import java.util.Collection;
import java.lang.Object;
import java.util.Arrays;
import java.lang.Math;
import java.util.*;
 
class maxisum
{
	static int[] freq=new int[10005];
	static int[] ans=new int[10005];
	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int i,j;
        int k;
        for(i=1;i<=t;i++)
        {
        	//System.out.print("Case #"+i+": ");
        	Arrays.fill(freq,0);
        	Arrays.fill(ans,0);
        	st=new StringTokenizer(br.readLine());
        	int n = Integer.parseInt(st.nextToken());
        	//freq = new int[n*n+1];
        	//ans = new int[n*n+1];
        	for(j=0;j<2*n-1;j++)
        	{
        		st=new StringTokenizer(br.readLine());
        		for(k=0;k<n;k++)
        		{
        			int temp = Integer.parseInt(st.nextToken());
        			freq[temp]++;
        		}
        	}
        	//System.out.println("fre "+Arrays.toString(freq));
        	int m =0;
        	for(k=0;k<freq.length;k++)
        	{
        		
        		//System.out.println("frrqk= "+freq[k]);
        		if(freq[k]%2 != 0)
        		{
        			//System.out.println("k= "+k);
        			ans[m++] = k;
        		}
        	}
        	Arrays.sort(ans);
        	//System.out.println(Arrays.toString(ans));
        	System.out.print("Case #"+i+": ");
        	for(k=0;k<ans.length;k++)
        	{
        		if(ans[k]!=0)
        			System.out.print(ans[k]+" ");
        	}
        	System.out.println();
        }
    }
} 