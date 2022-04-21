package googlejam1.p544;
import java.io.*;
import java.util.*;

public class a {
	public static void main(String[] args) {
        final String inputFile = "A-large";
        Scanner sc = null;
        PrintWriter pw = null;
        
        try {
            int n = 0;
            int plates = 0;
            String[] vals;
            
            sc = new Scanner(new FileReader(inputFile + ".in"));
            pw = new PrintWriter(new FileWriter(inputFile + ".out"));
            n = Integer.parseInt(sc.nextLine());
            
            for(int id = 1; id <= n; id++){
                
                plates = Integer.parseInt(sc.nextLine());
                
                vals = sc.nextLine().split(" ");
                
                int a,b = 0;
                int minA = 0;
                int minDiff = 0;
                int diff = 0;
                
                for(String s : vals) {
                    a = b;
                    b = Integer.parseInt(s);
                    if(b < a) {
                        diff = a-b;
                        minA += diff;
                        if(diff > minDiff) {
                            minDiff = diff;
                        }
                    }
                }
                b = 0;
                int minB = 0;
                for(String s : vals) {
                    b = Integer.parseInt(s);
                    if(b < minDiff) {
                        minB += b;
                    }
                    else {
                        minB += minDiff;
                    }
                }
                if(b < minDiff)
                    minB -= b;
                else
                    minB -= minDiff;
                
                pw.print("Case #" + id + ": " + minA + " " + minB);
                
                pw.print("");
                
                pw.println();
            }
        }
        catch (Exception e) {
			System.out.println("Invalid Arguments!");
		}
        finally {
            if (pw != null) { 
                pw.flush();
                pw.close(); 
            } 
            if (sc != null) {
                sc.close();
            }
        } 
	}
}