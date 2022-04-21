package googlejam6.p220;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.valueOf;

public class ProblemB {

    public static void main(String[] args) throws Exception {
        InputStream stream = ProblemB.class.getClassLoader().getResourceAsStream("problemB-test");
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        int testCases = valueOf(reader.readLine());
        for(int i=0; i< testCases; i++) {
            System.out.print("Case #" + (i+1) + ":");
			Map<Integer, Integer> count = new HashMap<>();
			int size = valueOf(reader.readLine());
			for(int i1=0; i1<2*size-1; i1++) {
			    String[] split = reader.readLine().split(" ");
			    for(int j=0; j<split.length; j++) {
			        count.compute(valueOf(split[j]), (key, val) -> val==null?1:val+1);
			    }
			}
			List<Integer> result = new ArrayList<>();
			for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
			    if(entry.getValue()%2==1) {
			        result.add(entry.getKey());
			    }
			}
			Collections.sort(result);
            Integer[] solve = result.toArray(new Integer[size]);
            for(int a : solve) {
                System.out.print(" " + a);
            }
            System.out.println();
        }
    }
}
