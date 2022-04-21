package googlejam8.p476;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


public class CodeJam {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	     	BufferedReader br = new BufferedReader(new FileReader("in.txt"));
	     	BufferedWriter bw=new BufferedWriter(new FileWriter("es1.txt"));
	        
	        int T,N=0;
	        String l;
	       	T = Integer.valueOf(br.readLine());
	        for (int i=0;i<T;i++){
	        	  bw.write("Case #"+(i+1)+": ");
	        	N = Integer.valueOf(br.readLine());
	        	int []A = new int[N];
	        	l=br.readLine();
	        	
        		for(int k=0;k<N;k++)
        			A[k]=Integer.valueOf(l.split(" ")[k]);
        		
        		int max=0;
        		while(true){
        			max=0;
        			int secondmax=0;
        			int two=0;
        			for(int j=0;j<N;j++){
        				if(A[j]>A[max])max=j;
        				if(diffz(A)!=3)if(A[j]==A[max]&&j!=max){two=1;secondmax=j;}
        				
        				}
           			
        			if (A[max]==0)break;
        			A[max]--;
        			if( two==1)
        			{	
        				A[secondmax]--;
						int i1 = secondmax+1;
        				String b = i1 > 0 && i1 < 27 ? String.valueOf((char)(i1 + 64)) : null;
        				bw.write(b);
            			System.out.print(b);
        			}
					int i1 = max+1;
        			String a = i1 > 0 && i1 < 27 ? String.valueOf((char)(i1 + 64)) : null;
        			bw.write(a+" ");
        			System.out.print(a+" ");	
        		}
        		System.out.println();
	            bw.newLine();
	        }
	        br.close();
	        bw.close();
	   }
	private static int diffz(int[] A) {
		int a=0;
		for(int j=0;j<A.length;j++)if(A[j]!=0)a++;
		return a;
	}
}
