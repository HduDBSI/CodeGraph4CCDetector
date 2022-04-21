package googlejam3.p154;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class A {

    

    // *************************************************************************************
    // *********************************** FRAMEWORK
    // ***************************************
    // *************************************************************************************

    public static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    public static boolean isStandardInput = false;

    public static File input;
    public static FileReader inputReader;
    public static BufferedReader in;

    public static File output;
    public static FileWriter outputWriter;
    public static BufferedWriter out;

    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        isStandardInput = true;
        output = new File("test.out");
		outputWriter = new FileWriter(output);
		out = new BufferedWriter(outputWriter);
        isStandardInput = false;
		input = new File("A-large" + ".in");
		inputReader = new FileReader(input);
		in = new BufferedReader(inputReader);
		output = new File("A-large" + ".out");
		outputWriter = new FileWriter(output);
		out = new BufferedWriter(outputWriter);
		
		int T = Integer.parseInt(TOKEN());
		
		for (int t = 0; t < T; t++) {
		    int R = Integer.parseInt(TOKEN());
		    int C = Integer.parseInt(TOKEN());
		    int W = Integer.parseInt(TOKEN());
		    int answer = 0;
		
		    for (int i = 0; i < R; i++) {
		        answer += C / W;
		    }
		    if (C % W != 0) {
		        answer += 1;
		    }
		    answer += (W - 1);
			String line = "Case #" + (t + 1) + ": " + answer;
		
		    out.write(line);
			out.write("\n");
			System.out.println(line);
		}
        if (in != null)
		    in.close();
		if (inputReader != null)
		    inputReader.close();
		
		if (out != null)
		    out.flush();
		if (out != null)
		    out.close();
		if (outputWriter != null)
		    outputWriter.close();
    }

    

    // **************** PRINT METHODS ****************

    

    // **************** INPUT DECLARATION ****************

    

    // **************** INPUT READING ****************

    static String TOKEN() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(isStandardInput ? stdin.readLine() : in.readLine());
        return st.nextToken();
    }
}
