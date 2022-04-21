package googlejam8.p731;
import java.io.*;
import java.util.*;

public class SenateEvacuation {

	public static void main(String[] args) {
		// Set up files
		File file = new File("A-large.in");
		File outfile = new File("output.txt");
		if(!file.exists()) {
			System.err.println("File doesn't exist!");
			return;
		}
		// Set up data
		int T;
		int N;
		int[] parties;
		int total;
				
		try {
			// Set up streams
			BufferedReader fin = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			BufferedWriter fout = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outfile)));
			
			String line = fin.readLine();
			T = Integer.parseInt(line.trim());
			
			for(int caseNum=0; caseNum<T; ++caseNum) {
				line = fin.readLine();
				N = Integer.parseInt(line);
				parties = new int[N];
				total = 0;
				line = fin.readLine();
				String[] partyMembers = line.split(" ");
				for(int i=0; i<N; ++i) {
					parties[i] = Integer.parseInt(partyMembers[i]);
					total += parties[i];
				}
				
				String output = "";
				
				// Find the two biggest groups
				int max1 = 0;
				for(int i=0; i<N; ++i) {
					if(parties[i] > parties[max1])
						max1 = i;
				}
				int max2 = 0;
				if(max1 == 0)
					max2 = 1;
				for(int i=0; i<N; ++i) {
					if(i != max1 && parties[i] > parties[max2])
						max2 = i;
				}
				
				// Pare down the biggest group to be the same size as the second biggest group
				while(parties[max1] > parties[max2]) {
					String thisOut = "" + (char)(max1 + 65);
					--parties[max1];
					--total;
					if(parties[max1] > parties[max2]) {
						thisOut += (char)(max1 + 65);
						--parties[max1];
						--total;
					}
					output += thisOut + " ";
				}
				
				// Evacuate everyone else in any order
				// First get a count of everyone else
				int totalNotMax = total;
				totalNotMax -= 2*parties[max1];
				while(totalNotMax > 0) {
					String thisOut = "";
					for(int i=0; i<N; ++i) {
						if(i != max1 && i != max2 && parties[i] > 0) {
							thisOut += (char)(i + 65);
							--parties[i];
							--total;
							--totalNotMax;
							break;
						}
					}
					for(int i=0; i<N; ++i) {
						if(i != max1 && i != max2 && parties[i] > 0) {
							thisOut += (char)(i + 65);
							--parties[i];
							--total;
							--totalNotMax;
							break;
						}
					}
					output += thisOut + " ";
				}
				
				// Evacuate the two biggest parties by making one from each go until they're all gone
				while(total > 0) {
					String thisOut = "";
					thisOut += (char)(max1 + 65);
					thisOut += (char)(max2 + 65);
					--parties[max1];
					--parties[max2];
					total -= 2;
					output += thisOut + " ";
				}
				
				System.out.println("Case #" + (caseNum+1) + ": " + output.trim());
				fout.write("Case #" + (caseNum+1) + ": " + output.trim() + "\n");
			}
			
			// Clean up streams
			fin.close();
			fout.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
	}
}
