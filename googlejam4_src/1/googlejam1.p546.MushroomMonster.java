package googlejam1.p546;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MushroomMonster {
	public static void main(String[] args) {
		String fileAddress = "C:\\Users\\di\\Documents\\googleCodeJam\\A-large.in";
		try {
			FileInputStream fstream = new FileInputStream(fileAddress);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			
			PrintWriter writer = new PrintWriter("C:\\Users\\di\\Documents\\googleCodeJam\\A-output-2.txt", "UTF-8");
			
			String strLine;
			int i = 0;
			while ((strLine = br.readLine()) != null) {
				String[] strs = strLine.split(" ");
				if(strs.length < 2) continue;
				
				i++;
				int res_m1 = 0;
				int res_m2 = 0;
				int max_diff = 0;
				for(int j=0; j<strs.length-1; j++) {
					int pre = Integer.parseInt(strs[j]);
					int nex = Integer.parseInt(strs[j+1]);
					
					if(nex < pre) {
						int diff = pre - nex;
						res_m1 += diff;
						if(diff > max_diff) max_diff = diff;
					}
				}
				
				for(int j=0; j<strs.length-1; j++) {
					int cur = Integer.parseInt(strs[j]);
					if(cur > max_diff) res_m2 += max_diff;
					else res_m2 += cur;
				}
				
				writer.println("Case #" + i + ": " + res_m1 + " " + res_m2);
			}
			
			writer.close();
			br.close();
			fstream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
