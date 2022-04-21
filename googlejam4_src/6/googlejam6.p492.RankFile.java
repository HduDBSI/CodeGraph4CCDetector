package googlejam6.p492;
import java.io.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class RankFile {
    // final static String PROBLEM_NAME = "GCJTemplate";
    // final static String WORK_DIR = "/Users/anishnag/Desktop/Google Code Jam 2016/Round 1" + PROBLEM_NAME + "/";

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new FileReader("input.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
        int caseCnt = sc.nextInt();
        for (int caseNum=0; caseNum<caseCnt; caseNum++){
            System.out.println("Processing Test Case " + (caseNum + 1));
            pw.print("Case #" + (caseNum + 1) + ": ");
			RankFile r = new RankFile();
            int n = sc.nextInt();
			  Integer[][] input = new Integer[2 * n - 1][n];
			  int[] count = new int[2501];
			  String result = "";
			
			  for (int i = 0; i < input.length; i++) {
			    for (int j = 0; j < input[i].length; j++) {
			      input[i][j] = sc.nextInt();
			      count[input[i][j]]++;
			    }
			  }
			
			  for (int i = 1; i < count.length; i++) {
			    if (count[i] % 2 != 0) {
			      result += (i + " ");
			    }
			  }
			
			  pw.write(result.substring(0, result.length() - 1) + "\n");
        }
        pw.flush();
        pw.close();
        sc.close();
    }
}
