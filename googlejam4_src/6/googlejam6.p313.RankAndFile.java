package googlejam6.p313;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RankAndFile {
	public static void main(String args[]){

		String path = "round1A/RankAndFile/";
		String filename = path + "B-large.in";
		String out = path + "result_large.txt";
		File file = new File(filename);
		File outfile = new File(out);

		BufferedReader br = null;
		PrintWriter pw = null;

		try {
			br = new BufferedReader(new FileReader(file));
			pw = new PrintWriter(new BufferedWriter(new FileWriter(outfile)));

			int testCase = Integer.parseInt(br.readLine());

			for(int t=1;t<=testCase;t++){
				System.out.println("test "+ t);

				int[] count = new int[2501];
				Arrays.fill(count, 0);

				int N = Integer.parseInt(br.readLine());
				for(int i=0;i<2*N-1;i++){
					String[] numbers = br.readLine().split(" ");
					for(String tmp : numbers){
						int number = Integer.parseInt(tmp);
						count[number]++;
					}
				}

				List<Integer> list = new ArrayList<Integer>();

				for(int i=1;i<=2500;i++){
					if(count[i]==0){
						continue;
					}

					if(count[i] % 2 != 0){
						list.add(i);
					}
				}

				Collections.sort(list);

				String result = "";
				for(int i=0;i<N;i++){
					result += list.get(i) + " ";
				}

				pw.println("Case #"+ t + ": " + result);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.exit(1);
				}
			}
			if(pw != null){
				pw.close();
			}
		}
	}

}
