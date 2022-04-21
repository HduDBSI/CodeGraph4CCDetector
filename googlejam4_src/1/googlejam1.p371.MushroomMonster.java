package googlejam1.p371;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MushroomMonster {
	
	static final String CASE_PREFIX = "Case #";
    static final String COLON = ":";
    static final String BLANK_SPACE = " ";
    static final String COLON_SPACE = COLON+BLANK_SPACE;
    
    /**
	 * 
	 * Declare any static variable over here
	 */
	
    public static void main(String[] args) {
    	
    	String root_path = "C:/Vijay/Workspaces/GoogleCodeJam/";
        String fileName=root_path+"inputFiles/2015/MushroomMonster/A-large";
        
        try (Scanner reader = new Scanner(new BufferedReader(new FileReader(fileName+".in")));
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName+"_out.txt"), "utf-8"))	){
		
		    //String inputLine = reader.readLine();
		    int T = reader.nextInt();
		    for(int caseNumber=1;caseNumber<=T;caseNumber++){
		    	int N = reader.nextInt();
		        int[] mush = new int[N];
		        for(int i=0;i<N;i++){
		        	mush[i] = reader.nextInt();
		        }
				int result = 0;
				int a = mush[0];
				for(int i=1;i<mush.length;i++){
					int b = mush[i];
					if(b<a){
						result+=a-b;
					}
					a=b;
				}
		        
		        int result1 = result;
				int result3 = 0;
				int rate = 0;
				int a1 = mush[0];
				for(int i=1;i<mush.length;i++){
					int b=mush[i];
					if(b<a1){
						int temp = a1-b;
						if(rate<temp)
							rate=temp;
					}
					a1=b;
				}
				
				System.out.println("Rate-->"+rate);
				
				for(int i=0;i<mush.length-1;i++){
					a1=mush[i];
					int tem = a1-rate;
					if(tem>=0)
						result3+=rate;
					else{
						result3+=rate+tem;
						tem=0;
					}
					
				}
		        int result2 = result3;
		        
		        
		        // write output
		        writer.write(CASE_PREFIX+caseNumber+COLON_SPACE+result1+BLANK_SPACE+result2);
		        writer.newLine();
		    }
		    
		} catch (IOException ex) {
		    Logger.getLogger(MushroomMonster.class.getName()).log(Level.SEVERE, null, ex);
		}
        System.out.println("Done executing");
     }
    
  
    
}

