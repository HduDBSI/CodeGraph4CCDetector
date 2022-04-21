package googlejam3.p368;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) {

		String filename = "src/round1B/input-B";
		//String filename = "src/round1B/B-small-practice";
		//String filename = "src/round1B/B-large-practice";

		FileInputStream file;
		int T;

		try {
			file = new FileInputStream(filename+".in");

			BufferedReader in = new BufferedReader(new InputStreamReader(file));


			T = Integer.parseInt(in.readLine());

			BufferedWriter bw = new BufferedWriter(new FileWriter(filename+".out"));

			for (int i=0; i<T; i++) {
				int ind = i+1;
				// parser
				String data[] = in.readLine().split(" ");
				int K = Integer.parseInt(data[0]);
				int L = Integer.parseInt(data[0]);
				int S = Integer.parseInt(data[0]);
				
				char[] key = in.readLine().toCharArray();
				char[] target = in.readLine().toCharArray();

				int res = 0;
				// calcul
				// bananes maximales
				int banana_max = 0;
				
				
				double proba = 1;
				for (int j=0; j<target.length; j++) {
					double cpt=0;
					for (int k=0; k<key.length; k++) {
						if (key[k]==target[j])
							cpt++;
					}
					proba *= cpt/(double)K;
				}
				
				System.out.println("Result "+i+": "+res);
				bw.write("Case #"+ind+": "+res+"\n");
			}
			bw.close();

			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
