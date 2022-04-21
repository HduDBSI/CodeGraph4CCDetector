package googlejam3.p388;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Problem1 {
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(new FileReader("A-small-attempt0.in"));
	        int T = scanner.nextInt();
	        int[] Rs = new int[T];
	        int[] Cs = new int[T];
	        int[] Ws = new int[T];
	        for(int i=0; i<T; i++) {
	        	Rs[i] = scanner.nextInt();
	        	Cs[i] = scanner.nextInt();
	        	Ws[i] = scanner.nextInt();
	        }  
	        PrintWriter out = new PrintWriter(new FileWriter("output1.txt"));        
	        for(int i=0; i<T; i++) {
	        	int count = Cs[i]/Ws[i];
	        	count += Ws[i]-1;
	        	if(Cs[i]%Ws[i] != 0) {
	        		count++;
	        	}
	        	count *= Rs[i];
	        	out.println("Case #" + (i+1) + ": " + count);
	        }
	        out.close();	       
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
