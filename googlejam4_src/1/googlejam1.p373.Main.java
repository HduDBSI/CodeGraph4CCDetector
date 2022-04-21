package googlejam1.p373;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
 
 
public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter file = new PrintWriter("output.txt");
		
		int t = Integer.parseInt(in.readLine());
		for(int i = 0; i < t; ++i){
			int n = Integer.parseInt(in.readLine());
			String line[] = in.readLine().split(" ");
			int [] mush = new int [n];
			int wayOne = 0;
			int old = Integer.parseInt(line[0]);
			double gap = 0;
			for(int j = 0; j < n; ++j){
				if(j!=0){
					old = mush[j-1];
				}
				mush[j] = Integer.parseInt(line[j]);
				if(old-mush[j]>0){
					wayOne+=old-mush[j];
					if(old-mush[j]>gap)gap=old-mush[j];
				}
			}
			
			int wayTwo = 0;
			double rate = gap;
			double leftover = 0;
			for(int j = 0; j < n-1; ++j){
				
				int amount = (int)(rate+leftover);
				leftover = rate+leftover-amount;
				if(rate > mush[j])wayTwo+=mush[j];
				else wayTwo += amount;
			}
			
		
			
			
			file.println("Case #"+(i+1)+": "+wayOne+" "+wayTwo);
		}
		file.close();
		in.close();
	}
}; 