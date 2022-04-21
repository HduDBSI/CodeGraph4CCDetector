package googlejam8.p138;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class A{
	static final String inFile="A-small.in";
	static final String outFile="A.out";
	
	static int t;
	static String line,str;
	static String[] row;
	static int[] a,b;
	static boolean debug = false;
	static long sum,maj,rem;
	
	public static void main(String [ ] args) throws IOException{
		A r = new A();
		int i,k,l,n;
		
		BufferedReader br = new BufferedReader(new FileReader(A.inFile));
		try {
			File file = new File(A.outFile);
			if (!file.exists()) {file.createNewFile();}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
		    A.line = br.readLine();
		    A.t = Integer.valueOf(A.line); //1 <= T <= 100
		    
		    for(l=0;l<A.t;l++){
		
		    	bw.write("Case #"+(l+1)+": ");
		    	
		    	A.line = br.readLine(); //S
		    	n = Integer.valueOf(A.line);
		    	A.a = new int[n];
		    	Arrays.fill(A.a, 0);
		    	A.sum = 0;
				A.line = br.readLine(); //S
				A.row = A.line.split("\\s");
		    	for(i=0;i<n;i++){
		        	A.a[i] = Integer.valueOf(A.row[i]);
		        	A.sum+=A.a[i];
		    	}
		    	A.rem = A.sum;
		    	A.maj = A.sum/2;
		    	int max,pos1,pos2;
		    	for(;A.rem>0;){
		    		max=-1;pos1=-1;pos2=-1;
		    		
		        		for(i=0;i<n;i++){
		        			if(A.a[i]>max){
		        				max = A.a[i];
		        				pos1=i;
		        			}
		        		}
		        		//2nd
		        		for(i=0;i<n;i++){
		        			if(A.a[i] == max && i!=pos1){
		        				pos2=i;
		        			}
		        		}
		        	if(pos2>-1 && A.rem==3) pos2=-1;
		    		
		    		if(pos2>-1){
		    			bw.write(""+(char)('A'+pos1)+""+(char)('A'+pos2));
		    			A.a[pos1]--;
		    			A.a[pos2]--;
		    			A.rem-=2;
		    		} else {
		    			bw.write(""+(char)('A'+pos1));
		    			A.a[pos1]--;
		    			A.rem-=1;
		    		}
		        	
		        	if(A.rem>0) bw.write(" ");
		        	
		        	//check
		        	max=-1;
		        	for(i=0;i<n;i++){
			        	max = (A.a[i]>max)?A.a[i]:max;
		        	}
		        	if (max > A.rem/2) {
		        		System.out.println("Problem!");
		        	}
		    	}
		    	
		    	bw.write("\n");	
		    }
			bw.close();
		} finally {br.close();}
	}
}
	
