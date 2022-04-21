package googlejam6.p265;
import java.util.*;
public class b {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int numCases = input.nextInt();
	     
	    for (int n = 0; n < numCases; n++){
	    	
	    	int N = input.nextInt();
	    	int t;
	    	int [] hei = new int [2501];
	    	for (int i = 0; i < (2*N-1)*N; i++){
	    		t = input.nextInt();
	    		hei[t]++;
	    	}
	    	int [] ans = new int [50];
	    	int mm=0;
	    	for (int i = 1; i < 2501; i++){
	    		if(hei[i]%2==1){
	    			ans[mm]=i;
	    		mm++;
	    		}
	    	}
		    	
	    	System.out.printf("Case #%d:", n + 1);
	    	for (int i = 0; i < N; i++)
	    		System.out.printf(" %d",ans[i]);
	    	System.out.println();
	    }
	}

}
