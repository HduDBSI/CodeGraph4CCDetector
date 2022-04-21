package googlejam1.p168;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

 
public class Main {
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader br = new BufferedReader(new FileReader(new File("A-large.in")));
    BufferedWriter bw = new BufferedWriter(new FileWriter(new File("A-large.out")));
    
    int testCases = Integer.parseInt(br.readLine());
    
    for (int i = 0; i < testCases; i++) {
      
      int size = Integer.parseInt(br.readLine());
      
      int[] input = new int[size];
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      for (int j = 0; j < size; j++) {
        input[j] = Integer.parseInt(st.nextToken());
      }
	long result1 = 0;
	long result2 = 0;
	int difference, maxDifference = 0;
	
	for (int i1 = 1; i1 < input.length; i1++) {
	  difference = input[i1-1] - input[i1];
	  maxDifference = Math.max(maxDifference, difference);
	  if (difference > 0) {
	    result1 += difference;
	  }
	}
	
	
	for (int i2 = 0; i2 < input.length - 1; i2++) {
	  result2 += Math.min(input[i2], maxDifference);
	}
      
      String outString = String.valueOf(result1) + " " + String.valueOf(result2);
      
      bw.write("Case #" + String.valueOf(i+1) + ": " + outString + "\n");
    }
    
    br.close();
    bw.close();    
    
  }

}
