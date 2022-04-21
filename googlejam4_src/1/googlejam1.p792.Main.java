package googlejam1.p792;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class Main {

	public static void main(String[]args) throws NumberFormatException, IOException{
	//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedReader br = new BufferedReader(new FileReader("input.in"));
		 PrintWriter out = new PrintWriter("output.txt");
		int t = Integer.parseInt(br.readLine());
		for(int i = 0;i<t;i++){
			String[]in = br.readLine().split(" ");
			int n = Integer.parseInt(in[0]);
			in = br.readLine().split(" ");
			int[]arr = new int[n];
			long max = Long.MIN_VALUE;
			for(int  j = 0;j<n;j++)
			{
				arr[j] = Integer.parseInt(in[j]);
				
			}
			long e1 = 0;
			double rate =0.0;
			for(int j = 0;j<n-1;j++){
				if(arr[j]>arr[j+1]){
					e1+=(arr[j]-arr[j+1]);
				}
				if(arr[j]>arr[j+1]){
					if((((arr[j]-arr[j+1])*1.0)/10.0 >rate)){
						rate = ((arr[j]-arr[j+1])*1.0)/10.0;
					}
				}
			}
		
			long eaten = 0;
			for(int j = 0;j<n-1;j++){
				eaten+=Math.min(arr[j], rate*10);
				
			}
			out.println("Case #"+(i+1)+": "+e1+" "+eaten);
			
			
		}
		
		br.close();
		out.close();
		
	}


}
