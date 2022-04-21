package googlejam6.p373;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by danielmckee on 4/15/16.
 */
public class RankFile {
    Scanner in;
    PrintWriter out;
    int n;
    String s;

    public RankFile() throws FileNotFoundException, UnsupportedEncodingException {
        in = new Scanner(new FileReader("rankfile_small_in.txt"));
        out = new PrintWriter("rankfile_large_out.txt", "UTF-8");
    }


    public static void main(String[] args) {
        RankFile r = null;
        try {
            r = new RankFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        int number = r.in.nextInt();
		for (int i = 0; i < number; i++) {
		    r.n = r.in.nextInt();
		    Map<Integer, Integer> counts = new TreeMap<>();
		    for (int k = 0; k < 2*r.n-1; k++) {
		        for (int j = 0; j < r.n; j++) {
		            int entry = r.in.nextInt();
		            if (counts.containsKey(entry)) {
		                counts.put(entry, counts.get(entry) + 1);
		            } else {
		                counts.put(entry, 1);
		            }
		        }
		    }
		    String strOut = "";
		    ArrayList<Integer> outputs = new ArrayList<>();
		    for (Integer num: counts.keySet()) {
		        if (counts.get(num)%2 != 0) {
		            outputs.add(num);
		        }
		    }
		    Collections.sort(outputs);
		    for (Integer num: outputs) {
		        strOut = strOut + String.valueOf(num) + " ";
		    }
		    strOut = strOut.substring(0, strOut.length()-1); // cut off space
		    int case_num = i + 1;
		    //System.out.println("Case #" + case_num + ": " + output);
		    r.out.println("Case #" + case_num + ": " + strOut);
		}
		r.out.close();
    }
}
