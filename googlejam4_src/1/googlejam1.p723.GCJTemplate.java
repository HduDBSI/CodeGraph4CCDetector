package googlejam1.p723;
import java.util.*;
import java.io.*;

public class GCJTemplate {
    
    public static void main(String[] args) {
        String filePath = new File("").getAbsolutePath();
        String readFilePath = filePath.concat("/src/text.in");
        String writeFilePath= filePath.concat("/src/text.out");

        File inFile = new File(readFilePath);
        
        FileWriter write = null;
        try {write = new FileWriter(writeFilePath);} catch (IOException ex) {}
        PrintWriter print_line = new PrintWriter(write);
        
        Scanner inLine = null;
        try {inLine = new Scanner(inFile);} catch (FileNotFoundException ex) {}
        
        int testCases = inLine.nextInt();
        
        //if using nextLine;
        //inLine.nextLine();
        
        for(int i = 0; i < testCases; i++){
            //String line = inLine.nextLine();
            //System.out.println(line);
            int ans1 = 0;
            int ans2 = 0;
            
            int numNums = inLine.nextInt();
            
            int[] numbers = new int[numNums];
            
            for(int j = 0; j < numNums; j++){
                numbers[j] = inLine.nextInt();
            }
            
            for(int j = 1; j < numNums; j++){
                if(numbers[j-1]-numbers[j] > 0){
                    ans1+=numbers[j-1]-numbers[j];
                }
            }
            
            int maxDiff = 0;
            for(int j = 1; j < numNums; j++){
                if(numbers[j-1]-numbers[j] > maxDiff)
                    maxDiff = numbers[j-1]-numbers[j];
            }
            
            for(int j = 1; j < numNums; j++){
                if(numbers[j-1] > maxDiff)
                    ans2+=maxDiff;
                else
                    ans2+=numbers[j-1];
            }
            
            //answer is string
            //print_line.printf("Case #%d: %s",i+1,"ans");
            
            //answer is int
            print_line.printf("Case #%d: %d %d",i+1,ans1,ans2);
            if(i < testCases-1)
                print_line.println();
        }
        
        print_line.close();
    }
    
}
