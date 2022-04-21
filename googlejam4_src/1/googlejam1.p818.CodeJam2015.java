package googlejam1.p818;
import java.util.*;
import java.io.*;

public class CodeJam2015 {

    final static String PROBLEM_NAME = "applause";
    final static String WORK_DIR = "/Users/eschra000/dev-work/CodeJam/" + PROBLEM_NAME + "/";
    final static String INPUT_FILE_NAME = "input.txt";
    final static String OUTPUT_FILE_NAME = "output.txt";

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new FileReader(WORK_DIR + INPUT_FILE_NAME));
        PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR
                + OUTPUT_FILE_NAME));
        int caseCnt = sc.nextInt();
        CodeJam2015 codeJam2015 = new CodeJam2015();
        for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
            //System.out.println("Processing test case " + (caseNum + 1));
            pw.print("Case #" + (caseNum + 1) + ": ");
            long start = System.currentTimeMillis();
            int intervals = sc.nextInt();
			int[] mushroomsAtInterval = new int[intervals];
			int y = 0;
			int z = 0;
			for (int i = 0; i < intervals; i++) {
			    mushroomsAtInterval[i] = sc.nextInt();
			}
			
			int maxRate = 0;
			for (int i = 1; i < intervals; i++) {
			    y += Math.max(mushroomsAtInterval[i-1] - mushroomsAtInterval[i], 0);
			    maxRate = Math.max(maxRate, mushroomsAtInterval[i-1] - mushroomsAtInterval[i]);
			}
			
			for (int i = 0; i < intervals - 1; i++) {
			    z+= Math.min(mushroomsAtInterval[i], maxRate);
			}
			
			pw.println(y + " " + z);
            long end = System.currentTimeMillis();
            //System.out.println("Case took " + (end - start) + "ms");
        }
        pw.flush();
        pw.close();
        sc.close();
    }

}
