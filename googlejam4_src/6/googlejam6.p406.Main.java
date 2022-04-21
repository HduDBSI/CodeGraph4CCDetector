package googlejam6.p406;
import java.util.*;

public class Main {

  public static void main(String args[]) {
    Main r = (new Main());
	Scanner cin = new Scanner(System.in);
	
	int T = cin.nextInt();
	for(int C=1; C<=T; ++C) {
	
	  int N = cin.nextInt();
	
	  int size = N * 2 - 1;
	  int count[] = new int[2501];
	
	  for(int i=0; i<size; ++i) {
	    for(int j=0; j<N; ++j) {
	      ++count[ cin.nextInt() ];
	    }
	  }
	
	  List<Integer> ans = new ArrayList<Integer>();
	  for(int i=1; i<=2500; ++i) {
	    if( count[i] % 2 != 0 ) { ans.add(i); }
	  }
	
	  System.out.print("Case #" + C + ":");
	  for( int v : ans ) {
	    System.out.print(" " + v);
	  }
	  System.out.println();
	
	}
  }

}
