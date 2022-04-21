package googlejam1.p386;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ProblemA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long startTime=System.currentTimeMillis();//Start time
		try {
			BufferedReader in = new BufferedReader(new FileReader("A-large.in"));
			BufferedWriter out = new BufferedWriter(new FileWriter("A-large.out"));
			String line = null;
			line = in.readLine();
			
			int T = Integer.parseInt(line);
			for(int i=0;i<T;i++){
				line = in.readLine();
				int N = Integer.parseInt(line);
				line = in.readLine();
				String [] tokens = line.split(" ");				
				int [] V = new int [N];
				for (int k=0;k<N;k++){
					V[k]= Integer.parseInt(tokens[k]);
				}
				int a=0,b=0,max=0;
				for (int k=0;k<N-1;k++){
					if (V[k]>V[k+1]){
						a=a+V[k]-V[k+1];
						if (V[k]-V[k+1]>max){
							max=V[k]-V[k+1];
						}
					}
				}
				for (int k=0;k<N-1;k++){
					if (V[k]>=max){
						b=b+max;
					} else{
						b=b+V[k];
					}
				}
				
				System.out.println("Case #" + (i+1) +": " + a + " " + b);	
				out.write("Case #" + (i+1) +": " + a + " " + b + "\n");
			}
			in.close();	
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException");
			e.printStackTrace();
		}
		long endTime=System.currentTimeMillis();//End time
		System.out.println("Running time is "+(endTime-startTime)+"ms");

	}

}
