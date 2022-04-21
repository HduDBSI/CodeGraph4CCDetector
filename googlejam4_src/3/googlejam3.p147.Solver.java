package googlejam3.p147;

import java.io.*;
import java.util.*;

public class Solver {
    static Scanner input;
    static Writer  output;
    public static void main(String args[]) {
        if(args.length != 1){
            System.out.println("Please specify the input file");
            return;
        }

		String filename = args[0];
		File f = new File(filename);
		BufferedReader br;

        if (!f.exists()) {
            System.out.println("Couldn't find file "+filename);
            return;
        } else if (f.isDirectory()) {
            System.out.println(filename+" is a directory");
            return;
        }

        try {
			br = new BufferedReader (new FileReader (f));
			input = new Scanner(br);
        } catch (IOException iox){
		    System.out.println("Problem reading " + filename );
        }

        try {
            output = new BufferedWriter(
                        new OutputStreamWriter(
                            new FileOutputStream(filename+".out"), "utf-8"));
            int T = input.nextInt();
			for(int caseNum=0; caseNum<T; caseNum++){
			    int R = input.nextInt();
			    int C = input.nextInt();
			    int W = input.nextInt();
			
			    int clearCount = C/W; //will round down
			    int hasExtra = C%W;
			    int findCount = clearCount + (W-1) + ((hasExtra!=0)?1:0);
			    int result = clearCount*(R-1) + findCount;
			
			    output.write("Case #"+(caseNum+1)+": ");
			    output.write(""+result);
			    output.write("\n");
			}
        } catch (IOException ex) {
            System.out.println("Couldn't open an output file");
            return;
        }

        try{
            output.close();
            input.close();
        } catch (IOException ex) {
        }
    }
}

