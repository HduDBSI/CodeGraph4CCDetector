package googlejam8.p676;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by dasha on 5/8/16.
 */
public class A1C {
    public static void main(String[] args) {
        A1C r = new A1C();
		try {
		    r.in = new Scanner(new FileInputStream(new File("A-large" + ".in")));
		    r.out = new PrintWriter(new File("A-large" + ".out"));
		    int tests = r.in.nextInt();
			for (int i = 1; i <= tests; i++) {
			    int n = r.in.nextInt();
			    int[] quantity = new int[n];
			    int maxInd = 0;
			    int min = Integer.MAX_VALUE;
			
			
			    HashMap<Integer, ArrayList<Integer>> aux = new HashMap<>();
			    int max = 0;
			    for (int j = 0; j < n; j++) {
			        quantity[j] = r.in.nextInt();
			        if (quantity[j] >= quantity[maxInd]) {
			            maxInd = j;
			        }
			        min = Math.min(quantity[j], min);
			        max = Math.max(quantity[j], max);
			        if (!aux.containsKey(quantity[j])) {
			            aux.put(quantity[j], new ArrayList<>());
			        }
			
			        aux.get(quantity[j]).add(j);
			    }
			
			
			    int[] arCopy = Arrays.copyOf(quantity, quantity.length);
			    Arrays.sort(arCopy);
			
			
			
			    r.out.print("Case #" + i + ": ");
			
			    int ind = arCopy.length - 1;
			    while(aux.size() > 1) {
			        int curMax = arCopy[ind];
			
			        while (arCopy[ind - 1] == curMax) {
			            ind--;
			        }
			        int nextMax = arCopy[ind - 1];
			        int toDel = curMax - nextMax;
			        for (int j = 0; j < toDel; j++) {
			            for (int sen  : aux.get(curMax)) {
			                r.out.print(((char)('A' + sen)) + " ");
			                quantity[sen]--;
			            }
			        }
			        aux.get(nextMax).addAll(aux.get(curMax));
			        aux.remove(curMax);
			        ind--;
			    }
			
			    ind = n - 1;
			    while (ind > 1) {
			        for (int j = 0; j < quantity[ind]; j++) {
			            r.out.print(((char)('A' + ind)) + " ");
			        }
			        quantity[ind] = 0;
			        ind--;
			    }
			
			    for (int j = 0; j < quantity[ind]; j++) {
			        r.out.print("AB" + " ");
			    }
			    r.out.println();
			
			}
		    r.out.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
    }

    Scanner in;
    PrintWriter out;
}
