package googlejam6.p657;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class RankAndFile {
	private int mT = -1;
	private int[] mN;
	private String[][] mNData;
	
	public static void main(String[] args) {
		RankAndFile countingSheep = new RankAndFile();
		try {
			BufferedReader br = new BufferedReader(new FileReader("./src/rankandfile.txt"));
			countingSheep.mT = Integer.parseInt(br.readLine());
			
			countingSheep.mN = new int[countingSheep.mT];
			countingSheep.mNData = new String[countingSheep.mT][];
			for(int i=0; i<countingSheep.mT; i++) {
				countingSheep.mN[i] = Integer.parseInt(br.readLine());
				countingSheep.mNData[i] = new String[2*countingSheep.mN[i]-1];
				for(int j=0; j < 2*countingSheep.mN[i]-1; j++) {
					countingSheep.mNData[i][j] = br.readLine();
				}
			}
			br.close();
			
			
			System.out.println("Total testcases: " + countingSheep.mT);
			for(int i=0; i<countingSheep.mT; i++) {
				System.out.println("Testcase #" + i + ": " + countingSheep.mN[i]);
				for(int j=0; j<2*countingSheep.mN[i]-1; j++) {
					System.out.println(countingSheep.mNData[i][j]);
				}
			}
			for (int i=0; i<countingSheep.mT; i++) {
						int N = countingSheep.mN[i];
						HashMap<String, Integer> mCountTable = new HashMap<>();
						for(int j=0; j<2*N-1; j++) {
							String[] numbers = countingSheep.mNData[i][j].split(" ");
							for(int k =0; k<numbers.length; k++) {
								if(mCountTable.containsKey(numbers[k])) {
									mCountTable.put(numbers[k], mCountTable.get(numbers[k])+1);
								} else {
									mCountTable.put(numbers[k], 1);
								}
							}
						}
						
						
						
						Set<String> keys = mCountTable.keySet();
						ArrayList<Integer> mMiss = new ArrayList<>();
						for(String key : keys) {
			//				System.out.println(key + ":" + mCountTable.get(key));
							if(mCountTable.get(key) % 2 != 0) {
								mMiss.add(Integer.parseInt(key));
							}
						}
						
						java.util.Collections.sort(mMiss);
			//			for(int l=0; l<mMiss.size()  ; l++) {
			//				System.out.println(mMiss.get(l));
			//			}
						
						String str = "";
						for(int l=0; l<mMiss.size() -1 ; l++) {
							str += mMiss.get(l) + " ";
						}
						str += mMiss.get(mMiss.size() -1);
						
						String data = "Case #" + (i+1) + ": " + str;
						try {
							PrintWriter	writer = new PrintWriter(new BufferedWriter(new FileWriter("./src/rankandfile_out.txt", true)));
							writer.println(data);
							writer.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
