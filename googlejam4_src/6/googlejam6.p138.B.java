package googlejam6.p138;
import java.util.*;

public class B
{
  private int N;
  
  List<List<Integer>> slips = new ArrayList<>();

  public B(int N)
  {
    this.N = N;
  }
  
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    
    int N = in.nextInt();
    
    for(int i = 0; i < N; ++i)
    {
      int inputN = in.nextInt();
      int caseN = i+1;
      
      B b = new B(inputN);
      
      for(int e = 0; e < (2*inputN-1); ++e)
      {
        List<Integer> slip = new ArrayList<>();
        
        for(int f = 0; f < inputN; ++f)
          slip.add(in.nextInt());
          
        b.slips.add(slip);
      }
	int[] counts = new int[10000];
	
	for(List<Integer> slip : b.slips)
	{
	  for(Integer i1 : slip)
	    counts[i1]++;
	}
	
	StringBuilder result1 = new StringBuilder();
	
	for(int i2 = 1; i2 <= 2500; ++i2)
	{
	  if(counts[i2]%2 != 0)
	  {
	    if(result1.length() > 0)
	      result1.append(" ");
	      
	    result1.append(""+i2);
	  }
	}
      
      String result = result1.toString();
      
      String resultString = result;
      
      System.out.println("Case #"+caseN+": "+resultString);
    }
  }
}
