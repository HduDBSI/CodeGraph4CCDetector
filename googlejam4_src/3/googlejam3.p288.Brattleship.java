package googlejam3.p288;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Brattleship {

    private static final String INPUT_FILE_NAME = "/home/wlq/workspace/leetcode/src/codejam/A-large.in";

    public static void main(String[] args) throws IOException {
        File file = new File(INPUT_FILE_NAME);
        InputStreamReader in = null;
        StringBuffer pzFile = new StringBuffer();
        in = new InputStreamReader(new FileInputStream(file));
        BufferedReader buffer = new BufferedReader(in);
        String line = null;
        int testCaseNumber = 0;
        int testCaseIndex=1;
        boolean isFirstLine = true;
        while ((line = buffer.readLine()) != null) {
            if (isFirstLine) {
                testCaseNumber = Integer.valueOf(line.trim());
                isFirstLine = false;
                continue;
            }
            String[] tempString = line.split(" ");
            int r = Integer.valueOf(tempString[0].trim());
            int c = Integer.valueOf(tempString[1].trim());
            int w = Integer.valueOf(tempString[2].trim());

            int result = 0;

            result = c / w;
            result = result * r;
            if (c % w == 0) {
                result += w - 1;
            } else {
                result += w;
            }

            // begin to handle

            // System.out.println("Case #" + testCaseIndex + ": " + additionalClap);
            File outFile = new File(INPUT_FILE_NAME + ".out");
			if (!outFile.exists()) {
			    try {
			        outFile.createNewFile();
			    } catch (IOException e) {
			        // TODO Auto-generated catch block
			        e.printStackTrace();
			    }
			}
			FileWriter fileWritter = null;
			try {
			    fileWritter = new FileWriter(outFile, true);
			    BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			    bufferWritter.append("Case #" + testCaseIndex + ": " + result + "\n");
			    bufferWritter.flush();
			    fileWritter.flush();
			    bufferWritter.close();
			} catch (IOException e) {
			    e.printStackTrace();
			}
            testCaseIndex++;

        }

    }

}
