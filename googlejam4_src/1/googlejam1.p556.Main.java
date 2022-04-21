package googlejam1.p556;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		FileReader in = new FileReader("in.in");
		File out = new File("out.out");
		BufferedReader reader = new BufferedReader(in);
		PrintWriter writer = new PrintWriter(out);
		
		int test = Integer.parseInt(reader.readLine());
		
		for(int i=1; i<=test; i++){
			int n = Integer.parseInt(reader.readLine());
			String[] data = reader.readLine().split("\\s");
			
			int t = Integer.parseInt(data[0]);
			int min1 = 0;
			int min2 = 0;
			
			int maxDif = 0;
			int[] numbers = new int[n];
			numbers[0] = t;
			for(int j=1; j<n; j++){
				int temp = Integer.parseInt(data[j]);
				numbers[j] = temp;
				
				if(t > temp)
					min1 +=  t - temp;
				
				if(t - temp > maxDif)
					maxDif = t - temp;
				
				t = temp;
			}
			
			if(numbers[0] > maxDif)
				min2 = maxDif;
			else
				min2 = numbers[0];
			
			for(int j=1; j<n-1; j++){
				if(numbers[j] > maxDif)
					min2+=maxDif;
				else
					min2+=numbers[j];
			}
		
		
			writer.print("Case #");
			writer.print(i);
			writer.print(": ");
			writer.print(min1);
			writer.print(" ");
			writer.println(min2);
		}
	
		reader.close();
		writer.close();

	}

}
