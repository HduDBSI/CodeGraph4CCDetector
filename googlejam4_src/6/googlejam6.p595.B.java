package googlejam6.p595;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class B
{
	public static final String PROBLEM_NO = "B";
	public static final String BASE_FOLDER = "C:\\Users\\Ash\\Ash\\Code Jam\\2016\\R1A\\Input";
	public static final String FS = File.separator;
	
//	public static final String SMALL_IN_FILE = BASE_FOLDER + FS + PROBLEM_NO + FS + PROBLEM_NO + "-small-ash.in";
//	public static final String SMALL_OUT_FILE = BASE_FOLDER + FS + PROBLEM_NO + FS + PROBLEM_NO + "-small-ash.out";
	public static final String SMALL_IN_FILE = BASE_FOLDER + FS + PROBLEM_NO + FS + PROBLEM_NO + "-small-attempt0.in";
	public static final String SMALL_OUT_FILE = BASE_FOLDER + FS + PROBLEM_NO + FS + PROBLEM_NO + "-small-attempt0.out";
	public static final String LARGE_IN_FILE = BASE_FOLDER + FS + PROBLEM_NO + FS + PROBLEM_NO + "-large.in";
	public static final String LARGE_OUT_FILE = BASE_FOLDER + FS + PROBLEM_NO + FS + PROBLEM_NO + "-large.out";
	
	public static void main(String[] args)
	{
//		processFile(SMALL_IN_FILE, SMALL_OUT_FILE);
		try {
			BufferedReader reader = new BufferedReader(new FileReader(LARGE_IN_FILE));
			BufferedWriter writer = new BufferedWriter(new FileWriter(LARGE_OUT_FILE));
			
			int cases = Integer.parseInt(reader.readLine());
			
			for (int caseNum=1; caseNum<= cases; caseNum++) {
				
				int n = Integer.parseInt(reader.readLine());
				List<Integer> counts = new ArrayList<Integer>();
				for (int i=1; i<=2500; i++) {
					counts.add(0);
				}
				
				for (int i=0; i<2*n-1; i++) {
					String in = reader.readLine();
					String[] split = in.split(" ");
					for (String tmp : split) {
						Integer integer = Integer.parseInt(tmp);
						counts.set(integer-1, counts.get(integer-1)+1);
					}
				}
				
				String missing = "";
				int counter = 0;
				for (int i=0; i<counts.size(); i++) {
					if (counts.get(i) % 2 != 0) {
						missing += (i+1) + " ";
						counter++;
						if (counter >= n) {
							break;
						}
					}
				}
				writer.write("Case #" + caseNum + ": " + missing.trim() + "\n");
			}
			
			writer.flush();
			writer.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
