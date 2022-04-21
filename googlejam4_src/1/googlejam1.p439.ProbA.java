package googlejam1.p439;


import java.io.*;
import java.util.*;

public class ProbA {

	/**
	 * Assumes input/output file names passed on command line
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader brIn = new BufferedReader(new FileReader(args[0]));
		BufferedWriter bwOut = new BufferedWriter(new FileWriter(args[1]));
		
		String sLine; 
		int ca=1;
		brIn.readLine(); // skip first line
		while((sLine = brIn.readLine())!=null) {
			int N = Integer.parseInt(sLine);
			int [] m = new int[N];
			sLine = brIn.readLine();
			String [] fields = sLine.split(" ");
			int totalDec = 0;
			int maxDec = 0;
			int prev = 0;
			for(int i=0; i<m.length; i++) {
				m[i] = Integer.parseInt(fields[i]);
				if(i!=0) {
					int dec = prev - m[i];
					if(dec > maxDec)
						maxDec = dec;
					if(dec > 0) {
						totalDec += dec; 
					}
				}
				prev = m[i];
			}
			int rateEst = 0;
			for(int i=0; i<m.length-1; i++) {
				rateEst += Math.min(maxDec, m[i]);
			}
			String msg = totalDec + " " + rateEst;
			bwOut.write("Case #" + ca + ": " + msg + "\r\n");
			ca++;
		}
		brIn.close();
		bwOut.close();
	}

}
