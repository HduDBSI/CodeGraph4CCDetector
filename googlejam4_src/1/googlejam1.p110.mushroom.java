package googlejam1.p110;
import java.io.*;
import java.util.*;
public class mushroom{
	public static void main(String[] args) throws IOException{
		BufferedReader f= new BufferedReader(new FileReader("mushroom.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mushroom.out")));
		int nmnmnm = Integer.parseInt(f.readLine());
		for(int nmnm=0; nmnm<nmnmnm; nmnm++){
			int n = Integer.parseInt(f.readLine());
			int[] a = new int[n];
			StringTokenizer st = new StringTokenizer(f.readLine());
			a[0] = Integer.parseInt(st.nextToken());
			int sum=0;
			int max =0;
			for(int i=1; i<n; i++){
				a[i] = Integer.parseInt(st.nextToken());
				if(a[i]<a[i-1]){
					sum+=a[i-1]-a[i];
				}
				if(max<a[i-1]-a[i]){
					max=a[i-1]-a[i];
				}
			}
			out.print("Case #" + (nmnm+1) + ": " + sum + " ");
			sum=0;
			for(int i=0; i<n-1; i++){
				if(a[i]<max){
					sum+=a[i];
				}
				else{
					sum+=max;
				}
			}
			out.println(sum);
		}
		out.close();
		System.exit(0);
	}
}