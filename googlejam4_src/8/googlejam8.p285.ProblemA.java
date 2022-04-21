package googlejam8.p285;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.math.*;

public class ProblemA {

    private static final String PROBLEM_CODE = "A";
    private static final String INPUT_PATH = String.format("C:\\Users\\Yasu\\Downloads\\%s-large.in", PROBLEM_CODE);
//    private static final String INPUT_PATH = String.format("C:\\Users\\Yasu\\Downloads\\%s-small-attempt0.in", PROBLEM_CODE);
    private static final String OUTPUT_PATH = String.format("C:\\Users\\Yasu\\Downloads\\%s-out%s.txt", PROBLEM_CODE, System.currentTimeMillis());

    public static void main(final String[] args) {
        ProblemA app = new ProblemA();

        try {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(ProblemA.INPUT_PATH))))) {
		            List<String> answerList = new ArrayList<String>();
		            int testCaseCount = Integer.parseInt(br.readLine());
		            testCaseCount = 50;
		            for (int testCaseIndex = 0; testCaseIndex < testCaseCount; testCaseIndex++) {
		//                String element = br.readLine();
		                int n = Integer.parseInt(br.readLine()); 
		                int[] elem = new int[n];
		                String[] line = br.readLine().split(" ");
		                for(int i = 0 ; i < n; i++) {
		                    elem[i] = Integer.parseInt(line[i]);
		                }
						StringBuilder sb = new StringBuilder();
						while(true) {
						    
						    int max = 1;
						    List<Integer> maxIndexes = new ArrayList<>();
						    int lastCount = 0;
						    for(int i = 0 ; i < n; i++) {
						        lastCount+=elem[i];
						        if(max < elem[i]) {
						            max = elem[i];
						            maxIndexes = new ArrayList<>();
						            maxIndexes.add(i);
						        } else if(max == elem[i]) {
						            maxIndexes.add(i);
						        }
						    }
						    if(maxIndexes.size() == 0) break;
						    
						    sb.append((char) (maxIndexes.get(0) + 'A'));
						    elem[maxIndexes.get(0)]--;
						    if(maxIndexes.size() >= 2 && (lastCount > 3 || lastCount == 2)) {
						        sb.append((char) (maxIndexes.get(1) + 'A'));
						        elem[maxIndexes.get(1)]--;
						    }
						    
						    sb.append(" ");
						}
		                String answer = sb.substring(0, sb.length() - 1); 
		//                String answer = solveProblem(element); 
		                answerList.add(answer);
		                
		                System.out.printf("%s: %s : %s \r\n", testCaseIndex + 1, elem, answer);
		            }
					final List<String> solve = answerList;
		            final String FORMAT = "Case #{0}: {1}";
					try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File (ProblemA.OUTPUT_PATH))))){
					    for (int i = 0; i < solve.size(); i++) {
					        Object[] ans = new Object[2];
					        ans[0] = String.valueOf(i + 1);
					        ans[1] = solve.get(i);
					        String write = MessageFormat.format(FORMAT, ans);
					        bufferedWriter.write(write);
					        bufferedWriter.newLine();
					    }
					} catch (Exception e) {
					    e.printStackTrace();
					}
		        } catch(Exception e) {
		            e.printStackTrace();
		        }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

