package googlejam9.p131;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class B{
	static final String inFile="B-small.in";
	static final String outFile="B.out";
	
	static int t,n,count;
	static long m, rem;
	static String line,str,s,u;
	static String[]row;
	static int[][]a;
	static boolean debug = false;
	
	public static void main(String [ ] args) throws IOException{
		B r = new B();
		int i,j,k,l;
		
		BufferedReader br = new BufferedReader(new FileReader(B.inFile));
		try {
			File file = new File(B.outFile);
			if (!file.exists()) {file.createNewFile();}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
		    B.line = br.readLine();
		    B.t = Integer.valueOf(B.line); //1 <= T <= 200
		
			B.a = new int[50][50];
		    for(l = 0; l < B.t; l++){
		    	B.line = br.readLine();
				B.row = B.line.split("\\s");
				B.n = Integer.valueOf(B.row[0]);
				B.m = Long.valueOf(B.row[1]);
				for(i = 0; i < B.n; i++){
					Arrays.fill(B.a[i], 0);
				}
				
				//m
				bw.write("Case #"+(l+1)+": ");
				if(B.m > Math.pow(2,B.n-2)){
					bw.write("IMPOSSIBLE\n");
				} else {
					if (B.m>0) {
						int i1,j1,k1;
						B.a[0][B.n-1]=1;
						B.rem = B.m;
						int pow = 0;
						for(; B.rem>0; ){
							B.rem/=2;pow++;
						}
						B.rem = (long) Math.pow(2, pow-1);
						
						//System.out.println("AC"+rem);
						//create pow matrix
						for(i1 = 1; i1 <pow; i1++){
							for(j1 = i1; j1 <pow; j1++){
									if(i1<j1) B.a[i1][j1]=1;
									if(j1<B.n-1) B.a[j1][B.n-1]=1;
									B.a[0][j1]=1;
							}
						}
						
						//last 2^pow-2^pow elements
						B.rem = B.m - (long) Math.pow(2, pow-1);
						if(B.rem>0){
							//connect i = pow
							B.a[0][pow]=1;
							B.a[pow][B.n-1]=1;
							B.rem--;//1 done
							//add a[pow][j] iff 1 is in j position in binary representation
							//System.out.println("AB"+(rem));
							//System.out.println("AA"+pow);
								
							for(int step=1;B.rem>0;step++){
								System.out.print(B.rem%2);
								if(B.rem%2==1) {
									B.a[pow][pow-step]=1;
									//System.out.println("A["+(pow-step));
								}
								B.rem/=2;
							}
							//System.out.println("AA");
						}
					}
					//output
					bw.write("POSSIBLE\n");
					for(i = 0; i < B.n; i++){
						for(j = 0; j < B.n; j++){
							bw.write(""+B.a[i][j]);
						}
						bw.write("\n");
					}
				}
		    }
			bw.close();
		} finally {br.close();}
	}
}
