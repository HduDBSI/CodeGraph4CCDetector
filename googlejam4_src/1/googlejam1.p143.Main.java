package googlejam1.p143;
import java.util.*;

public class Main {

  public static void main(String args[]) {
    Main r = (new Main());
	Scanner cin = new Scanner(System.in);
	
	int T = cin.nextInt();
	for(int C=1; C<=T; ++C) {
	
	  int N = cin.nextInt();
	  int arr[] = new int[N];
	  for(int i=0; i<N; ++i) {
	    arr[i] = cin.nextInt();
	  }
	
	  int sum = 0;
	  int max = 0;
	  for(int i=1; i<N; ++i) {
	    int diff = Math.max(arr[i - 1] - arr[i], 0);
	    max = Math.max(max, diff);
	    sum += diff;
	  }
	
	  int res = 0;
	  for(int i=1; i<N; ++i) {
	    res += Math.min(arr[i - 1], max);
	  }
	
	  System.out.println("Case #" + C + ": " + sum + " " + res);
	
	}
  }

}
