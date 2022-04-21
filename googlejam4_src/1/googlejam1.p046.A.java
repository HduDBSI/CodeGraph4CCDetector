package googlejam1.p046;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class A {

	public static void main(String[] args) throws IOException {
		
		BufferedReader input = new BufferedReader(new FileReader("C:\\Users\\William Li\\Desktop\\input.txt"));
		PrintWriter output = new PrintWriter(new FileWriter("C:\\Users\\William Li\\Desktop\\output.txt"));
		
		int T = Integer.parseInt(input.readLine());
		
		for (int t = 1; t <= T; t++){
			
			int N = Integer.parseInt(input.readLine());
			
			int method1 = 0;
			
			String[] nextLine = input.readLine().split(" ");
			int[] mushrooms = new int[N];
			
			for (int i = 0; i < nextLine.length; i++){
				
				mushrooms[i] = Integer.parseInt(nextLine[i]);
				
			}
			
			for (int i = 1; i < mushrooms.length; i++){
				
				method1 += Math.max(mushrooms[i - 1] - mushrooms[i], 0);
				
			}
			
			int method2 = 0;
			int maxdiff = 0;
			
			for (int i = 1; i < mushrooms.length; i++){
				
				maxdiff = Math.max(mushrooms[i - 1] - mushrooms[i], maxdiff);
				
			}
			
			for (int i = 0; i < mushrooms.length - 1; i++){
				
				if (mushrooms[i] - maxdiff < 0){
					
					method2 += mushrooms[i];
					
				}else{
					
					method2 += maxdiff;
					
				}
				
			}
			
			output.println("Case #" + t + ": " + method1 + " " + method2);
			
		}
		
		input.close();
		output.close();
		
		System.exit(0);
		
	}

}