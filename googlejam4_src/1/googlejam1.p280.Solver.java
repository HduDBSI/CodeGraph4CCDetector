package googlejam1.p280;
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
			    int N = input.nextInt();
			    long[] m = new long[N];
			
			    for (int i=0; i<N; i++) {
			        m[i] = input.nextInt();
			    }
			
			    long prev = m[0];
			    long maxDelta = 0;
			    long sumDelta = 0;
			    for(int i=1; i<N; i++){
			        long delta = m[i]-prev;
			        prev = m[i];
			        if(delta < 0){
			            maxDelta  = Math.max(maxDelta, Math.abs(delta));
			            sumDelta += Math.abs(delta);
			        }
			    }
			
			    long sumTwo = 0;
			    for(int i=0; i<N-1; i++){
			        sumTwo += Math.min(m[i],maxDelta);
			    }
			
			    output.write("Case #"+(caseNum+1)+": ");
			    output.write(""+sumDelta);
			    output.write(" ");
			    output.write(""+sumTwo);
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

