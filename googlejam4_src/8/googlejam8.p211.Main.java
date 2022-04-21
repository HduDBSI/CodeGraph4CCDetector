package googlejam8.p211;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Vector;

public class Main {
	public static final String ALPHABET[] = {
		"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
	};
    public static void main(String[] args) throws Exception {
        // set up scanner and iterate over test cases
        Scanner scanner = new Scanner(new FileInputStream(
            "C:\\Users\\Stefan\\Downloads\\A-large.in"));
        PrintStream output = new PrintStream(
            "C:\\Users\\Stefan\\Downloads\\A-large.out");
        int T = scanner.nextInt();
        for (int t = 1; t <= T; ++t) {
            // get parameters
            int N = scanner.nextInt();
            int[] parties = new int[N];
            int senatorsCount = 0;
            for (int n = 0; n < N; ++n)
            	senatorsCount += (parties[n] = scanner.nextInt());
            // solve problem
            output.print("Case #" + t + ":");
            while (senatorsCount > 0) {
            	// find largest party / parties
            	int maxC1 = 0;
            	int maxC2 = 0;
            	int maxI1 = 0;
            	int maxI2 = 0;
            	for (int party = 0; party < N; ++party)
            		if (parties[party] > maxC1) {
            			maxC2 = maxC1;
            			maxI2 = maxI1;
            			maxC1 = parties[party];
            			maxI1 = party;
            		}
            		else if (parties[party] == maxC1 || parties[party] > maxC2) {
            			maxC2 = parties[party];
            			maxI2 = party;
            		}
            	// remove at least one senator
            	output.print(" " + ALPHABET[maxI1]);
            	--maxC1;
            	--parties[maxI1];
            	--senatorsCount;
            	// decide if a second senator should leave
            	if (maxC1 > maxC2) {
            		// remove 2nd senator from this party
                	output.print(ALPHABET[maxI1]);
                	--maxC1;
                	--parties[maxI1];
                	--senatorsCount;
            	}
            	else if (senatorsCount == 1 || 2 * maxC2 > senatorsCount) {
            		// remove 2nd senator from 2nd party
                	output.print(ALPHABET[maxI2]);
                	--maxC2;
                	--parties[maxI2];
                	--senatorsCount;
            	}
            }
            output.println();
        }
        output.close();
        System.out.println("finished");
    }
}
