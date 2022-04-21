package googlejam9.p212;
import java.util.Scanner;
public class b {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int numCases = input.nextInt();
	     
	    for (int n = 0; n < numCases; n++){
	    	
	    	int b = input.nextInt();
	    	int m = input.nextInt();
	    	
	    	int[][] test = new int[b][b];
	    	int[] road = new int[b];
	    	
	    	for(int i = 0;i<b;i++)
	    		road[i]=1;
	    		
	    	int ans=0,tmp=0,t=0,br=0;
	    	for(int i = b-2;i>=0;i--)
	    	{ 	
	    		tmp=ans;
	    		t=0;
	    		br=i;
	    		for(int j = b-1;j>i;j--)
	    		{
	    			ans+=road[j];
	    			t+=road[j];
	    			test[i][j]=1;
		    		if(t>=m)
		    			break;
	    		}
	    		road[i]=ans-tmp;
	    		if(t>=m)
	    			break;

	    	}
	    	
	    	if(t>=m){
	    	System.out.printf("Case #%d: POSSIBLE\n", n + 1);
	    	if(t>m)
	    	{int tt=0;
	    		for(int i = br+1;i<b;i++){
	    			tt+=road[i];
	    			if(tt>m){
	    				test[br][i]=0;
	    				tt-=road[i];
	    			}
	    		}
	    	    	
	    	}
	    	int pos=0;
	    	for(int i = b-1;i>=0;i--){
	    		int tm=0;
	    		for(int j = 0;j<b;j++)
		    		tm+=test[i][j];
	    		if(tm>0)
	    			pos=i;
	    	}
	    	for(int i = 0;i<pos;i++)
	    	{
	    		test[i][i+1]=1;
	    	}
	    	for(int i = 0;i<b;i++){
	    		for(int j = 0;j<b;j++)
	    			System.out.printf("%d",test[i][j]);
	    		System.out.println();
	    		}
	    	}
	    	else
	    		System.out.printf("Case #%d: IMPOSSIBLE\n", n + 1);	

	    }
	}

}
