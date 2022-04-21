package googlejam6.p487;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class QuestionTwo {

    public static void main(String[] args) throws Exception {

        QuestionTwo questionTwo = new QuestionTwo();
//        String fileName = "B-small-attempt1";
//        String fileName = "small";
        String fileName = "B-large";
        String inputFile = "codeJam/2016/round_one/question_two/" + fileName + ".in";
        String outputFIle = "/Users/sdu/Dropbox/workspace/eclipse/JavaPractice/src/main/java/com/sdu/practice/codeJam/round_one/q2_" + fileName + ".out";

        ClassLoader classLoader = questionTwo.getClass().getClassLoader();
		File file = new File(classLoader.getResource(inputFile).getFile());
		
		try (Scanner scanner = new Scanner(file)) {
		
		    String line = scanner.nextLine();
		    int t = Integer.parseInt(line.trim());
		
		    int caseT = 0;
		
		    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
		            new FileOutputStream(outputFIle), "utf-8"));
		
		    while (++caseT <= t) {
		        int[] array = new int[2501];
		        ArrayList<Integer> result = new ArrayList<>();
		        String rStr = "";
		
		        line = scanner.nextLine();
		        int n = Integer.parseInt(line.trim());
		        int r = 0;
		        while (++r < 2*n) {
		            line = scanner.nextLine();
		            String[] chars = line.trim().split(" ");
		            for (int j = 0; j < n; j++) {
		                array[Integer.valueOf(chars[j])]++;
		            }
		
		        }
		
		        for (int j=0; j< 2500; j++) {
		            if (array[j] % 2 != 0) {
		                result.add(j);
		            }
		        }
		
		        for (int j = 0; j < result.size(); j++) {
		            rStr = rStr + result.get(j) + " ";
		        }
		
		        rStr = rStr.trim();
		
		        writer.write("Case #" + caseT + ": " + rStr);
		        writer.newLine();
		    }
		    scanner.close();
		    writer.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}

    }
}

