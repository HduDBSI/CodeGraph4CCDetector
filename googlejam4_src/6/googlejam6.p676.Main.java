package googlejam6.p676;
import java.util.*;

public class Main{
  
  public static void main(String[]args){
    
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    
    for(int zz = 1; zz <= T; zz++){
      int N = in.nextInt();
      
      int[] soldiers = new int[N*(2*N-1)];
      
      for(int i = 0; i < N*(2*N-1); i++){
        soldiers[i] = in.nextInt();
      }
      
      Arrays.sort(soldiers);
	int[] found = new int[N];
	int foundIndex = 0;
	
	int currentNum = soldiers[0];
	int numSum = 1;
	
	for(int i1 = 1, len = soldiers.length; i1 < len; i1++){
	  int currentCheck = soldiers[i1];
	  if(currentNum == currentCheck){
	    numSum++;
	  }else{
	    if(numSum % 2 == 1){
	      found[foundIndex] = currentNum;
	      foundIndex++;
	    }
	    numSum = 1;
	    currentNum = currentCheck;
	  }
	}
	
	if(numSum % 2 == 1){
	      found[foundIndex] = currentNum;
	    }
      
      int[] answer = found;
      
      System.out.printf("Case #%d: ", zz);
      
      for(int i = 0; i < N; i++){
        System.out.printf("%d ", answer[i]);
      }
      System.out.println();
    }
    
  }
}
