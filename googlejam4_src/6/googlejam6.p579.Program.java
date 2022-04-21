package googlejam6.p579;
import java.util.*;
import java.io.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Program {	
	
	public static void main(String[] args) throws IOException {		
		File inFile = new File(args[0]);
	//	File inFile = new File("B.in");
		Scanner in = new Scanner(new BufferedReader(new FileReader(inFile)));		//
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		//in.nextLine();
		
	//	/*
        File outFile = new File(args[1]);
        if (!outFile.exists()) {
        	outFile.createNewFile();
		}
		FileWriter fw = new FileWriter(outFile.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
      //  */
		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= t; ++i) {
			set.clear();
			int N = in.nextInt();	
			in.nextLine();
			for (int k = 0; k < 2 * N - 1; k++) {
				String[] s = in.nextLine().split(" ");				
				for (String str : s) {
					if (str.length() == 0) continue;
					int num = Integer.parseInt(str);
					if (set.contains(num)) set.remove(num);
					else set.add(num);
				}
			}
			
			List<Integer> num = new ArrayList<>();
			for (int n : set) {
				num.add(n);
			}
			Collections.sort(num);				
			StringBuilder sb = new StringBuilder();
			for (int n : num) sb.append(n).append(" ");
			sb.setLength(sb.length() - 1);
			String res = "Case #" + i + ": " + sb.toString();
			//String res = s;
			bw.write(res);
		    bw.newLine();
		}			
		in.close();  
		bw.close();
		
		/*
		String s = "--+-";
		System.out.println(flipCakes(s));
		*/
	}	
	
}
