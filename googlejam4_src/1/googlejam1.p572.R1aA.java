package googlejam1.p572;



import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;

public class R1aA {
public static void main(String args[]) throws Exception {
		
		String inFile = "A-large.in";// path to input file 
		String outFile =  "outputA.txt";
		
		LineNumberReader lin = new LineNumberReader(new InputStreamReader(new FileInputStream(inFile)));
		PrintWriter out = new PrintWriter(new File(outFile));
		int NCASE = Integer.parseInt(lin.readLine());
		for(int CASE = 1; CASE <= NCASE; CASE++) {
			out.print("Case #" + CASE + ": ");
			String l = lin.readLine();
			int N=Integer.parseInt(l);
			String l2 = lin.readLine();
			String  [] parts = l2.split(" ");
			int [] m= new int[N];
			for (int i=0; i<N; i++){
				m[i] = Integer.parseInt(parts[i]);
			}
			int y=0;
			int z=0;
			int max=0;

			for (int i=0; i<N-1; i++){
				if (m[i]-m[i+1]>=0){
					y=y+m[i]-m[i+1];
				}
			}
			
			for (int i=0; i<N-1; i++){
				if (m[i]-m[i+1]>=max){
					max=m[i]-m[i+1];
				}
			}
			for (int i=0; i<N-1; i++){
				if (m[i]>=max){
					z=z+max;
				} else {
					z=z+m[i];
				}
			}
			out.println(y +" "+z); 
			
		}

		lin.close();
		out.close();
	
		}		
}

