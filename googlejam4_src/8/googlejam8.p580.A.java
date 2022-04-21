package googlejam8.p580;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class A {
	public static void main(String[] args) throws IOException {
		BufferedReader bf= new BufferedReader(new FileReader("A-small-attempt2.in"));
		int t= Integer.parseInt(bf.readLine());
		PrintWriter out= new PrintWriter(new FileWriter("smallA.txt"));
		for(int c=1; c<=t; c++){
			int n= Integer.parseInt(bf.readLine());
			int p[]= new int [n];
			StringTokenizer st= new StringTokenizer(bf.readLine());
			out.printf("Case #%d:",c);
			for(int i=0; i<n; i++)
				p[i]= Integer.parseInt(st.nextToken());
			int max=0;
			int maxi=0;
			int max2=0;
			int max2i=0;
			int sum=0;
			do{
				max=0;
				maxi=0;
				max2=0;
				max2i=0;
				sum=0;
				for(int i=0; i<n; i++){
					int x= p[i];
					sum+=x;
					if(x>max){
						max2= max;
						max2i= maxi;
						max=x;
						maxi=i;
					}
					else
						if(x>max2){
							max2=x;
							max2i=i;
						}
				}
				//System.out.println(Arrays.toString(p));
				if(max>0){
				out.print(" "+((char)('A'+maxi)));
				max--;
				p[maxi]--;
				if(max2>max && max2>0 && max2-1<=(sum-2)/2.0 && sum!=3){
					out.print(((char)('A'+max2i)));
					p[max2i]--;
					continue;
				}
				if(max-1<=(sum-2)/2.0 && max>0 && sum!=3){
					out.print(((char)('A'+maxi)));
					max--;
					p[maxi]--;
				}
				
				}
				
			}while(sum!=0);
			out.println();
		}
		out.flush();
		out.close();
	}

}
