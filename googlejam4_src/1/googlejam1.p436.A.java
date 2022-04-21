package googlejam1.p436;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;


public class A {
	static public void main(String[] args)throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input.in"));
		PrintWriter out = new PrintWriter("output.txt");
		int t = Integer.parseInt(br.readLine());
		for(int z=1;z<=t;z++){
			int n = Integer.parseInt(br.readLine());
			String[] in = br.readLine().split(" ");
			int[] arr = new int[n];
			long max=-1;
			arr[0]=Integer.parseInt(in[0]);
			long y=0,x=0;
			for(int i=1;i<n;i++){
				arr[i]=Integer.parseInt(in[i]);
				if(arr[i]<=arr[i-1]){
					y+=arr[i-1]-arr[i];
					if(arr[i-1]-arr[i]>max)
						max=arr[i-1]-arr[i];
				}
			}
			
			for(int i=0;i<n-1;i++){
				x+=Math.min(max,arr[i]);
			}
			out.println("Case #"+z+": "+y+" "+x);
		}
		
		br.close();
		out.close();
	}
}
