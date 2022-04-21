package googlejam3.p120;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class A{
	
	static int t,r,c,w,a;
	static String line,str;
	static String[] row;
	static boolean debug = false;
	
	public static void main(String [ ] args) throws IOException{
		int i,j,k;
		
		
		BufferedReader br = new BufferedReader(new FileReader("A-large.in"));
	    try {
	    	File file = new File("aaa.out");
    		if (!file.exists()) {
    			file.createNewFile();
    		}
    		
    		FileWriter fw = new FileWriter(file.getAbsoluteFile());
    		BufferedWriter bw = new BufferedWriter(fw);
    		
	        line = br.readLine();
	        t = Integer.valueOf(line); //1 <= T <= 100.

			
	        for(i = 0; i < t; i++){
				
				line = br.readLine();
				row = line.split("\\s");
				r = Integer.valueOf(row[0]);
				c = Integer.valueOf(row[1]);
				w = Integer.valueOf(row[2]);
				
	        	//1 <= n <= 10^6.
				debug = false;
				a=0;
				
				if (r == 1 && c==w) {
					a=w;
				} else if (w==1) {
					a=r*c;
				} else { // c>=w>1
					j = c%w; //>=0
					k = c/w; //>=1
					if(j==0){
						a = k*(r-1)+k + w-1;
					} else {
						a = k*(r-1)+k + w;
					}
				}
				
				if(debug) System.out.println("-------");
    			bw.write("Case #"+(i+1)+": "+a+"\n");
	        }
	        
			bw.close();

	    } finally {
	        br.close();
	    }
	}
}
