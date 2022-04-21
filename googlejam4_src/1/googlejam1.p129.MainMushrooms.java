package googlejam1.p129;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainMushrooms {

	public static void main(String[] args) {

		FileInputStream file;
		int T;
		ArrayList<TestMushrooms> tests;

		try {

//			file = new FileInputStream("input_Mushrooms");
//			file = new FileInputStream("A-small-attempt0.in");
			file = new FileInputStream("A-large.in");

			BufferedReader in = new BufferedReader(new InputStreamReader(file));


			String buff = in.readLine();
			T = Integer.parseInt(buff);
			tests = new ArrayList<TestMushrooms>();

			for (int i=0; i<T; i++){

				int N;
				buff = in.readLine();
				N = Integer.parseInt(buff);

				int[] s = new int[N];
				buff = in.readLine();
				String[] data = buff.split(" ");				
				for (int j=0; j<N; j++) {
					s[j] = Integer.parseInt(data[j]);
				}
				
				tests.add(new TestMushrooms(N, s));
			}

			in.close();


			BufferedWriter bw = new BufferedWriter(new FileWriter("output_Mushrooms"));

			for (int i=0; i<T; i++) {
				int ind = i+1;
				TestMushrooms res = tests.get(i);
				System.out.println("Result "+ i + " : "+ res.getRes1() + " " + res.getRes2());
				bw.write("Case #"+ind+": "+res.getRes1()+" "+res.getRes2()+"\n");
			}
			bw.close();





		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
