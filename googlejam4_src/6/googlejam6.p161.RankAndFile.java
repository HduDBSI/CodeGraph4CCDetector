package googlejam6.p161;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by Nicholas on 4/15/2016.
 */
public class RankAndFile {

    static final boolean CONSOLE_MODE = false;
    static String fileName = "B-large";

    static File in, out;
    static PrintWriter writer;
    static Scanner reader;

    public static void main(String[] args) throws Exception{
        if(CONSOLE_MODE) {
            writer = new PrintWriter(System.out);
            reader = new Scanner(System.in);
        } else {
            in = new File("C:/Codejam/in/" + fileName + ".in");
            out = new File("C:/Codejam/result.out");
            writer = new PrintWriter(new FileOutputStream(out));
            reader = new Scanner(new FileInputStream(in));
        }

        int cases = reader.nextInt();
		
		System.out.println("Cases: " + cases);
		
		for(int i = 1; i <= cases; i++) {
		    System.out.println("On case " + i);
			int n = reader.nextInt();
			
			HashMap<Integer, Integer> set = new HashMap<>();
			
			int inputs = n * (2 * n - 1);
			
			for(int i1 = 0; i1 < inputs; i1++) {
			    int in = reader.nextInt();
			    set.put(in, set.getOrDefault(in, 0) + 1);
			}
			
			ArrayList<Integer> result1 = new ArrayList<>();
			
			for(Integer i2 : set.keySet()) {
			    if(set.get(i2) % 2 != 0)
			        result1.add(i2);
			}
			
			Collections.sort(result1);
		    List<Integer> result = result1;
		    writer.print("Case #" + i + ": ");
		    for(int j : result)
		        writer.print(j + " ");
		    writer.println();
		}

        writer.close();
        reader.close();
    }

}
