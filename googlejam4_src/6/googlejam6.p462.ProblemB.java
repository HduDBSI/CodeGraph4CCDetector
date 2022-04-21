package googlejam6.p462;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProblemB {

    private static final String PROBLEM_CODE = "B";
    private static final String INPUT_PATH = String.format("C:\\Users\\Yasu\\Downloads\\%s-large.in", PROBLEM_CODE);
//    private static final String INPUT_PATH = String.format("C:\\Users\\Yasu\\Downloads\\%s-small-attempt0.in", PROBLEM_CODE);
    private static final String OUTPUT_PATH = String.format("C:\\Users\\Yasu\\Downloads\\%s-out%s.txt", PROBLEM_CODE, System.currentTimeMillis());


    private static final String FORMAT = "Case #{0}: {1}";

    public static void main(String[] args) {
        ProblemB app = new ProblemB();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(ProblemB.INPUT_PATH))))) {
		    List<String> answerList = new ArrayList<String>();
		    int testCaseCount = Integer.parseInt(br.readLine());
		    for (int testCaseIndex = 0; testCaseIndex < testCaseCount; testCaseIndex++) {
		        
		        int n = Integer.parseInt(br.readLine());
		        int[][] elem = new int[2*n-1][n];
		        for(int i = 0 ; i < 2*n-1;i++) {
		            String[] line = br.readLine().split(" ");
		            for(int j = 0 ; j < n; j++) {
		                elem[i][j] = Integer.parseInt(line[j]);
		            }
		        }
				Map<Integer, Integer> map = new HashMap<>();
				for(int[] eA: elem) {
				    for(int e : eA) {
				        Integer num = map.get(e);
				        if(num == null) {
				            num = 0;
				        }
				        num++;
				        map.put(e, num);
				    }
				}
				
				Map<Integer, Integer> useMap = new TreeMap<>();
				for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
				    if(entry.getValue() % 2 == 1) {
				        Integer useNum = useMap.get(entry.getKey());
				        if(useNum == null) {
				            useNum = new Integer(0);
				        }
				        useNum++;
				        useMap.put(entry.getKey(), useNum);
				    }
				}
				
				StringBuilder sb = new StringBuilder();
				for(int k : useMap.keySet()) {
				    int v = useMap.get(k);
				    for(int i = 0 ; i < v; i++) {
				        sb.append(k + " ");
				    }
				}
		        String answer = sb.substring(0, sb.length() - 1); 
		        answerList.add(answer);
		        
		        System.out.printf("%s: %s : %s \r\n", testCaseIndex + 1, elem, answer);
		    }
		    try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File (ProblemB.OUTPUT_PATH))))){
			    for (int i = 0; i < answerList.size(); i++) {
			        Object[] ans = new Object[2];
			        ans[0] = String.valueOf(i + 1);
			        ans[1] = answerList.get(i);
			        String write = MessageFormat.format(ProblemB.FORMAT, ans);
			        bufferedWriter.write(write);
			        bufferedWriter.newLine();
			    }
			} catch (Exception e) {
			    e.printStackTrace();
			}
		} catch(Exception e) {
		    e.printStackTrace();
		}
//        int n = 3;
//        int[][] elem= new int[][]{
//            {2, 3, 5},
//            {2, 3, 4},
//            {1, 2, 3},
//            {3, 5, 6},
//            {1, 2, 3},
//        };
//        System.out.println(app.solveProblem(n, elem));
        
        
    }
}

