package googlejam3.p422;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Problem_A {

	public static void main(String[] args) {
		//String inFile = "//Users//lixuefei//Documents//JavaWorkspace//Interview//src//GoogleCodeJamRound2//in.txt";
		String inFile = "//Users//lixuefei//Documents//JavaWorkspace//Interview//src//GoogleCodeJamRound2//A-small-attempt0.in";
		String outFile = "//Users//lixuefei//Documents//JavaWorkspace//Interview//src//GoogleCodeJamRound2//result.txt";
		int n = 0;
		String line;
		try {
			FileReader fileReader = new FileReader(inFile);
			BufferedReader br = new BufferedReader(fileReader);
			FileWriter fileWriter = new FileWriter(outFile);
			BufferedWriter bw = new BufferedWriter(fileWriter);
			line = br.readLine();
			n = Integer.parseInt(line);
			for(int i = 0; i < n ; i++){
				line = br.readLine();
				
				String[] parts = line.split(" ");
				long R = Long.parseLong(parts[0]);
				long C = Long.parseLong(parts[1]);
				long W = Long.parseLong(parts[2]);
				long result = (C-1)/W+W;
				bw.write("Case #" + (i+1) + ": " + result + "\n");
				
			}
			br.close();
			bw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}

