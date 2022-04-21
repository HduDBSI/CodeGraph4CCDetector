package googlejam8.p451;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class MainA {

	public static void main(String[] args) {

		//String filename = "src/y20161C/A-test";
		//String filename = "src/y20161C/A-small-attempt1";
		String filename = "src/y20161C/A-large";

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
				int N = Integer.parseInt(in.readLine());
				String data[] = in.readLine().split(" ");
				int P[] = new int[N];
				for (int j=0; j<N; j++) {
					P[j] = Integer.parseInt(data[j]);
				}
				String res1 = "";
				
				//looking for the 2 highest
				int max1 = 0;
				int max2 = 0;
				int ind1 = -1;
				int ind2 = -1;
				for (int i1=0; i1<N; i1++) {
					if (P[i1] > max1) {
						if (max1 > max2) {
							max2 = P[i1];
							ind2 = i1;
						} else {
							max1 = P[i1];
							ind1 = i1;
						}
					} else if (P[i1] > max2) {
						max2 = P[i1];
						ind2 = i1;
					}
				}
				
				int tab[] = P.clone();
				//egalize the 2 highest
				while (tab[ind1] != tab[ind2]) {
					if (tab[ind1] > tab[ind2]) {
						res1 += " "+(char)('A'+ind1);
						tab[ind1]--;
					} else {
						res1 += " "+(char)('A'+ind2);
						tab[ind2]--;
					}				
				}
				
				//remove others
				for (int i2=0; i2<N; i2++) {
					if (i2 == ind1 || i2 == ind2)
						continue;
					while (tab[i2] > 1) {
						res1 += " "+(char)('A'+i2)+(char)('A'+i2);
						tab[i2] -= 2;
					}
					if (tab[i2] == 1) {
						res1 += " "+(char)('A'+i2);
					}
				}
				
				while (tab[ind1] > 0) {
					res1 += " "+(char)('A'+ind1)+(char)('A'+ind2);
					tab[ind1]--;
					tab[ind2]--;
				}
				
				res1 = res1.substring(1);
				
				// calcul
				String res = res1;
				
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
