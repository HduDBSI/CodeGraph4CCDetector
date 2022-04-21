package googlejam2.p317;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pivis
 */
public class Problem1 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File f = new File("C:\\Users\\Pivis\\Documents\\NetBeansProjects\\GCJ_B\\src\\a.in");
        File out = new File("C:\\Users\\Pivis\\Documents\\NetBeansProjects\\GCJ_B\\src\\a.out");
        Scanner in = new Scanner(new FileReader(f));
        BufferedWriter output = new BufferedWriter(new FileWriter(out));
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i1 = 1; i1 <= 1000000; i1++) {
		    if (i1 <= 20) map.put(i1, i1);
		    else {
		        int r1 = map.get(i1-1);
		        if (i1%10 != 0) {
		            int num = i1;
					int res = 0;
					while (num > 0) {
					    int d = num%10;
					    res *= 10;
					    res += d;
					    num /=10;
					}
					int rev = res;
		            if (rev < i1) {
		                int r2 = map.get(rev);
		                map.put(i1, Math.min(r1, r2)+1);
		            } else {
		                map.put(i1, r1+1);
		            }
		        } else {
		            map.put(i1, r1+1);
		        }
		    }
		}
        
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int N = in.nextInt();
            String text = "Case #" + (i+1) + ": " + map.get(N) + "\n";
            output.write(text);
            
        }
        output.close();
    }
}
