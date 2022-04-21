package googlejam2.p056;

import java.io.*;
import java.util.*;

/**
 *
 * @author Tom
 */
public class GoogleCodeJam {
    public static void main(String[] args) {
        Scanner input = null;
        //MagicTrick[] puzzles;
        //CookieClickerAlpha[] puzzles;
        CounterCulture[] puzzles;
        try {
            input = new Scanner(new FileInputStream("input.in"));
            //puzzles = MagicTrick.readFile(input);
            //puzzles = CookieClickerAlpha.readFile(input);
            puzzles = CounterCulture.readFile(input);
            input.close();
        }
        catch(Exception e) {
            System.out.println("hi");
            System.out.println(e);
            System.exit(0);
            return;
        }
        
        String[] results = new String[puzzles.length];
        for(int i = 0; i < puzzles.length; ++i) {            
            results[i] = "Case #" + (int)(i + 1) + ": " + puzzles[i].solve();
            System.out.println("Case #" + (int)(i + 1) + " done");
        }        
        
        PrintWriter output = null;
        try {
            output = new PrintWriter(new FileOutputStream("output.txt"));
            for(int i = 0; i < results.length; ++i) {
                output.println(results[i]);
            }
            output.close();
        }
        catch(Exception e) {
            System.out.println(e);
            System.exit(0);
            return;
        }
        
        /*PrintWriter output = null;
        try {
            output = new PrintWriter(new FileOutputStream("output.txt"));
            for(int i = 0; i < puzzles.length; ++i) {
                output.println("Case #" + (int)(i + 1) + ":");
                
                String[] ans = puzzles[i].solve();
                for(int j = 0; j < ans.length; ++j) {
                    output.println(ans[j]);
                }
                
                System.out.println("Case #" + (int)(i + 1) + " done");
            }
            output.close();
        }
        catch(Exception e) {
            System.out.println(e);
            System.exit(0);
            return;
        }*/
    }
}
