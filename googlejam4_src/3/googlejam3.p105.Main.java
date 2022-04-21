package googlejam3.p105;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		FileReader in = new FileReader("F:\\download\\A-large.in");
		BufferedReader br = new BufferedReader(in);
		FileWriter out = new FileWriter("F:\\download\\CodeJam\\out.txt");
		BufferedWriter bw = new BufferedWriter(out);
		
		int t = Integer.parseInt(br.readLine());
		for (int c = 0; c < t; c++){

//			int l = Integer.parseInt(br.readLine());

			String line = br.readLine();
			StringTokenizer St1 = new StringTokenizer(line, " ");
			int ro = Integer.valueOf(St1.nextToken()).intValue();
			int co = Integer.valueOf(St1.nextToken()).intValue();
			int w = Integer.valueOf(St1.nextToken()).intValue();
			
			int answer = ((int)(co / w)) * (ro - 1);
			answer += w;

			while (true){
				if (co > w){
					co -= w;
					answer ++;
				}
				else{
					break;
				}
			}
			
			
			
			bw.write(String.format("Case #%d: %d\n", c+1, answer));
		}


		br.close();
		in.close();
		bw.close();
		out.close();

	}
	

}

