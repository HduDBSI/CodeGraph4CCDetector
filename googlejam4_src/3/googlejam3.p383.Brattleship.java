package googlejam3.p383;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Brattleship {

    public static void main(String[] args) throws Exception {
    	String path = "C:\\Users\\Ziming\\Downloads\\";

        String input = path + "A-large.in";
        String output = path + "A-large.out";


        List<String> inputLines = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new FileReader(input));
        String line = reader.readLine();

        while (line != null) {
            inputLines.add(line);
            line = reader.readLine();
        }

        reader.close();

        StringBuilder outputResult = new StringBuilder();

        int totalCase = Integer.parseInt(inputLines.get(0));
        inputLines.remove(0);

        for (int cn = 0; cn < totalCase; cn++) {
            String caseResult = "";
            
            // -------------------------------------------
            // Solve problem, put result in caseResult.
            
            String ln = inputLines.get(0);
            inputLines.remove(0);
            
            String [] paramStrs = ln.split(" ");
            int R = Integer.parseInt(paramStrs[0]);
            int C = Integer.parseInt(paramStrs[1]);
            int W = Integer.parseInt(paramStrs[2]);
            
//            System.out.println(String.format("%d %d %d", R, C, W));
            if(W == 1) {
            	caseResult = Integer.toString(R*C);
            } else {
            	int s = 0;
            	s += (C / W) * R - 1;
            	int c = C - (C / W - 1) * W;
            	int e = c - W;
            
            	if(e > 0) {
            		s += 1;
            	}
            	s += W;
            	caseResult = Integer.toString(s);
            }

            
            //caseResult = "0";
            
            // Solve problem end.
            // -------------------------------------------
            
            String outputLine = String
                    .format("Case #%d: %s", cn + 1, caseResult);

            System.out.println(outputLine);
            if(outputResult.length() > 0) {
                outputResult.append("\n");
            }
            outputResult.append(outputLine);
        }


        PrintWriter writer = new PrintWriter(output);
        writer.print(outputResult.toString());
        writer.flush();
        writer.close();
        
        System.out.println("program finished :)");
    }
}


