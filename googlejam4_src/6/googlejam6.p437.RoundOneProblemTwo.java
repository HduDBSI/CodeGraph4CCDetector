package googlejam6.p437;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class RoundOneProblemTwo {

    public static void main(String[] args) {

//        String inPutFile = "/Users/KiRaN/Desktop/CodeBase/Google_CodeBase/SheepSleep/src/small.in";
//        String outPutFile = "/Users/KiRaN/Desktop/CodeBase/Google_CodeBase/SheepSleep/src/small.out";
        
        String inPutFile = "/Users/KiRaN/Desktop/CodeBase/Google_CodeBase/SheepSleep/src/large.in";
        String outPutFile = "/Users/KiRaN/Desktop/CodeBase/Google_CodeBase/SheepSleep/src/large.out";
        
        
        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(inPutFile));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outPutFile));

            // Total number of test cases
            int noOfTestCases = Integer.valueOf(bufferedReader.readLine());
            
            
            
            for (int testCase = 0; testCase < noOfTestCases; testCase++){
                
                Set<Integer> distinctHeights = new HashSet<>();
                Map<Integer,Integer> repetitionCount = new HashMap<>();
                TreeSet<Integer> resultSet = new TreeSet<Integer>();
                
                int gridSize = Integer.parseInt(bufferedReader.readLine());
                int noOfLinesToRead = 2*gridSize-1;
                for(int i=0; i<noOfLinesToRead; i++){
                    String currRow = bufferedReader.readLine();
                    String[] heightsInCurrentRow = currRow.split(" ");
                    for(String a:heightsInCurrentRow) {
                        int currHeight = Integer.valueOf(a);
                        if(distinctHeights.contains(currHeight)) {
                            int heightCount = repetitionCount.get(currHeight);
                            repetitionCount.put(currHeight,heightCount+1);
                        } else {
                            distinctHeights.add(currHeight);
                            repetitionCount.put(currHeight, 1);
                        }
                    }
                    
                }
                
                repetitionCount.entrySet().stream().filter(currRecord -> 
                    ((currRecord.getValue() & 1)!=0?true:false) == true
                ).forEach(currRecord -> resultSet.add(currRecord.getKey()));
                
                bufferedWriter.write("Case #" + (testCase + 1) + ": " + resultSet.toString().replace("[", "").replace("]", "").replaceAll(", "," "));
                System.out.print("Case #" + (testCase + 1) + ": " + resultSet.toString().replace("[", "").replace("]", "").replaceAll(", "," "));
                bufferedWriter.write("\n");
                System.out.print("\n");

                

            }
                
            bufferedReader.close();
            bufferedWriter.close();

        } catch (FileNotFoundException fileNotFoundException) {

            System.out.println("Some Exception: " + fileNotFoundException.getMessage());
            fileNotFoundException.printStackTrace();

        } catch (IOException ioException) {

            System.out.println("Some Exception: " + ioException.getMessage());
            ioException.printStackTrace();

        } catch (Exception exception) {
            
            System.out.println("Some Exception: " + exception.getMessage());
            exception.printStackTrace();
        }

    }

}
