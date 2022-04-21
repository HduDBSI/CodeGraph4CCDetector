package googlejam3.p210;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;


public class Problem1CA {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(new File(args[0]));
        File outFile = new File(args[1]);
        FileOutputStream os = new FileOutputStream(outFile);
        OutputStreamWriter osw = new OutputStreamWriter(os);
        Writer w = new BufferedWriter(osw);
		        
		int cases = sc.nextInt();

		for (int i=0; i<cases; ++i) {
			
			int R = sc.nextInt();
			int C = sc.nextInt();
			int W = sc.nextInt();
			
			int shots = (C/W)*R+W;
			if (C%W == 0) {
				--shots;
			}
			
			w.write("Case #" + Integer.toString(i+1) + ": " + Integer.toString(shots) + "\n");
		}

		w.close();
		sc.close();
	}
}
