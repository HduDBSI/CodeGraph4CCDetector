package googlejam1.p093;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class ProblemA {
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		FileWriter writer = new FileWriter("C:/Users/Max/Documents/Java Workspaces/Google Code Jam/Round 1A 2015/src/output.txt");		
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:/Users/Max/Documents/Java Workspaces/Google Code Jam/Round 1A 2015/src/input.txt"));
			int numCases = Integer.parseInt(br.readLine());
			for (int caseNum = 1; caseNum <= numCases; caseNum++) {
				String line = br.readLine();
				int n = Integer.parseInt(line);
				line = br.readLine();
				Scanner sc = new Scanner(line);
				long y = 0;
				long maxDifference = 0;
				int last = Integer.parseInt(sc.next());
				ArrayList<Integer> sizes = new ArrayList<Integer>();
				sizes.add(last);
				while(sc.hasNext()){
					int next = Integer.parseInt(sc.next());
					sizes.add(next);
					if(next < last){
						y += (last - next);
						if(last - next > maxDifference){
							maxDifference = last - next;
						}
					}
					last = next;
				}
				long z = 0;
				for(int i = 0; i < sizes.size() - 1; i++){
					if(sizes.get(i) < maxDifference){
						z += sizes.get(i);
					} else {
						z += maxDifference;
					}
				}
				writer.write("Case #" + caseNum + ": " + y + " " + z + "\n");
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.close();
	}
}
