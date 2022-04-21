package googlejam3.p511;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Brattleship {
	
    public static void main(String[] args) {
    	String root_path = "C:/Vijay/Workspaces/GoogleCodeJam/";
    	String fileName=root_path+"inputFiles/2015/Brattleship/A-small-attempt0";
        
        String inputFileName = fileName+".in";
        String outputFileName = fileName+"_out.txt";

        try (Scanner reader = new Scanner(new BufferedReader(new FileReader(inputFileName)));
        	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFileName), "utf-8"))){
           
            int T = reader.nextInt();
            for(int caseN=1;caseN<=T;caseN++){
            	int R = reader.nextInt();
            	int C = reader.nextInt();
            	int W = reader.nextInt();
				int R1 = R;
				int result1=0;
				R1=1;
				int d=C-W;
				
				int a=0;
				if(d>0){
					a=d/W;
					int b=d%W;
					if(b>0)
						a++;
				}
				result1=a+W;
            	int result = result1;
                // write output
                writer.write("Case #"+caseN+": "+result);
                writer.newLine();
            }
            
        } catch (IOException ex) {
            System.out.println("Exception:"+ex.getMessage());
        }
        System.out.println("Done executing");
     }
}

