package googlejam1.p384;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Problem_A {

	public static void main(String[] args) {
		String inFile = "//Users//lixuefei//Documents//JavaWorkspace//Interview//src//GoogleCodeJamRound1//inin.txt";
		String outFile = "//Users//lixuefei//Documents//JavaWorkspace//Interview//src//GoogleCodeJamRound1//result.txt";
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
				int N = Integer.parseInt(line);
				int[] M = new int[N];
				line = br.readLine();
				String[] parts = line.split(" ");
				for(int j = 0; j < N; j++){
					M[j] = Integer.parseInt(parts[j]);
				}
				int result = 0;
				for(int i1 = 0; i1 < N-1; i1++){
					if(M[i1] > M[i1+1]){
						result += M[i1] - M[i1+1];
					}
				}
								
				int result1 = result;
				int max = 0; 
				int result3 = 0;
				for(int i2 = 0; i2 < N-1; i2++){
					if(M[i2] > M[i2+1]){
						int dif = M[i2]- M[i2+1];
						if(max < dif) max = dif;
					}
				}
				for(int i1 = 0; i1 < N-1; i1++){
					if(M[i1] >= max) result3 += max;
					else result3 += M[i1];
				}
				int result2 = result3;
				bw.write("Case #" + (i+1) + ": " + result1 + " "+ result2 +"\n");
				
			}
			br.close();
			bw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}

