package googlejam6.p233;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CodeJam {
	 public static void main(String[] args) throws NumberFormatException, IOException {
	     	BufferedReader br = new BufferedReader(new FileReader("in.txt"));
	     	BufferedWriter bw=new BufferedWriter(new FileWriter("soldiers.txt"));
	        
	        int T,N=0;
	        String l;
	       	T = Integer.valueOf(br.readLine());
	        for (int i=0;i<T;i++)
	            {
	        	String s="";
	        	N = Integer.valueOf(br.readLine());
	            int[][] lists = new int[2*N -1][N];
	        	for(int j=0;j<(2*N-1);j++){
	        		l=br.readLine();
	        		for(int k=0;k<N;k++)
	        			lists[j][k]=Integer.valueOf(l.split(" ")[k]);
	        	}
	        	
	        	int c=0;
	        	for (int m=1;m<2501;m++){
	        		c=0;
	        		for(int j=0;j<(2*N-1);j++)
		        		for(int k=0;k<N;k++)if(lists[j][k]==(m))c++;
		        		if(c%2!=0)s=s+m+" ";
	        		}
	        	
	        	
	            bw.write("Case #"+(i+1)+": "+s);bw.newLine();
	        }
	        br.close();
	        bw.close();
	   }
}
