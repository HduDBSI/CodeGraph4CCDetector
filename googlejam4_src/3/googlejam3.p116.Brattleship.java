package googlejam3.p116;
import java.io.*;

public class Brattleship {
    public static void main(String[] args) throws Exception {
        String filename = "A-large.in";
        File file = new File("/Users/tanin/Downloads/" + filename);
        File outFile = new File("/Users/tanin/Downloads/" + filename + ".out");
        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));
        int testCases = Integer.parseInt(br.readLine());
        for(int t=1;t<=testCases;t++){
            String[] tokens = br.readLine().split(" ");
            int R = Integer.parseInt(tokens[0]);
            int C = Integer.parseInt(tokens[1]);
            int W = Integer.parseInt(tokens[2]);
			int times = (C / W) * R;
			
			if ((C % W) > 0) {
			    times += W;
			} else {
			    times += W - 1;
			}

            int result = times;
            String outputLine = "Case #" + t + ": " + result + "\n";

            System.out.print(outputLine);
            bw.write(outputLine);
        }
        br.close();
        bw.close();
    }
}
