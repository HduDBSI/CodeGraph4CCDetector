package googlejam1.p162;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Mushroom {

  public static void main(String[] args) {

    BufferedReader reader = null;
	try {
	  reader = new BufferedReader(new FileReader(args[0]));
	  int n = Integer.parseInt(reader.readLine());
	  for (int i = 1; i <= n; ++i) {
	    reader.readLine();
		Mushroom r = new Mushroom();
	    List<Integer> intArray = new ArrayList<Integer>();
		for (String s : reader.readLine().split(" ")) {
		  intArray.add(Integer.parseInt(s));
		}
		int x = 0;
		int max = 0;
		for (int i1 = 1; i1 < intArray.size(); ++i1) {
		  if (intArray.get(i1) < intArray.get(i1 - 1)) {
		    int d = intArray.get(i1 - 1) - intArray.get(i1);
		    x += d;
		    max = Math.max(max, d);
		  }
		}
		int y = 0;
		for (int i2 = 1; i2 < intArray.size(); ++i2) {
		  y += Math.min(max, intArray.get(i2 - 1));
		}
		System.out.println("Case #" + i + ": " + x + " " + y);
	  }
	} catch (Exception e) {
	  e.printStackTrace();
	} finally {
	  if (reader != null) {
	    try {
	      reader.close();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	  }
	}
  }

}