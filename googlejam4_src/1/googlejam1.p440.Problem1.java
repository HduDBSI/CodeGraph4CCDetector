package googlejam1.p440;
// Code by PepeOfMath
//
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Problem1 {

    public static void main(String[] args) throws FileNotFoundException {

        //hard code the file location
        //open file
        //get number of test cases
        File f = new File("A-large.in");
        Scanner s = new Scanner(f);
        String line = s.nextLine();
        int T = Integer.parseInt(line);

        //open output file
        File f2 = new File("largeresult.txt");
        PrintWriter p = new PrintWriter(f2);

        for (int i = 1; i <= T; i++) {
            int num = Integer.parseInt(s.nextLine());
            String nums = s.nextLine();
            int[] vals = new int[num];
            Scanner scan = new Scanner(nums);
            for (int j = 0; j < num; j++) {
                vals[j] = scan.nextInt();
            }
            
            //Calculate for method1
            int count = 0;
            for (int j = 0; j < num-1; j++) {
                if(vals[j] - vals[j+1] > 0) {
                    count += vals[j] - vals[j+1];
                }
            }
            
            //Calculate for method2
            int count2 = 0;
            int maxrate = 0;
            for (int j = 0; j < num-1; j++) {
                if (vals[j] - vals[j+1] > maxrate) {
                    maxrate = vals[j] - vals[j+1];
                }
            }
            
            for (int j = 0; j < num - 1; j++) {
                count2 += Math.min(maxrate, vals[j]);
            }
            
            p.println("Case #" + i + ": " + count + " " + count2);
            
        }



        p.close();
        s.close();
    }

}   
