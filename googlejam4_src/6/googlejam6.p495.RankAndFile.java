package googlejam6.p495;


import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RankAndFile {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new File("RankAndFile.out"));
		RankAndFile r = new RankAndFile();
        int T = in.nextInt();
		for (int i=0; i<T; i++) {
		    int N = in.nextInt();
		    HashMap<Integer, Integer> heightCounts = new HashMap<>();
		    for (int j=0; j<(2*N-1)*N; j++) {
		        int h = in.nextInt();
		        if (heightCounts.containsKey(h)) {
		            int count = heightCounts.get(h);
		            heightCounts.put(h, count+1);
		        } else {
		            heightCounts.put(h, 1);
		        }
		    }
		    int missingNumbers[] = new int[N];
		    int j=0;
		    for (Map.Entry<Integer, Integer> entry: heightCounts.entrySet()) {
		        if (entry.getValue() % 2 == 1) {
		            missingNumbers[j] = entry.getKey();
		            j++;
		        }
		    }
		    Arrays.sort(missingNumbers);
		    StringBuilder sb = new StringBuilder();
		    for (j=0; j<N; j++) {
		        sb.append(" ");
		        sb.append(missingNumbers[j]);
		    }
		    out.println(String.format("Case #%d:%s", i+1, sb.toString()));
		}
        out.close();
    }
}
