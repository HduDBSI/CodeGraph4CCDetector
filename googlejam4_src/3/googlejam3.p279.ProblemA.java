package googlejam3.p279;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class ProblemA {
    
    static BufferedWriter bw;
    
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(new File("A-large.in"));
        bw = new BufferedWriter(new FileWriter(new File("output.txt")));
            
        int tc = sc.nextInt();
        for(int d=1;d<=tc;d++){
            bw.write("Case #"+String.valueOf(d)+": ");

            int r = sc.nextInt();
            int c = sc.nextInt();
            int w = sc.nextInt();
            
            int points = (c/w)*r;
            if(w>1){
                points += (w-1);
                if(c%w > 0)points += 1;
            }

            bw.write(String.valueOf(points));
            bw.newLine();
            bw.flush();   
        }
        
        sc.close();
        bw.close();
    }
}
