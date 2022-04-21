package googlejam6.p371;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q2 {
	public static void main(String[] args) throws IOException {
		FileInputStream in = null;
		in = new FileInputStream("input.in");
		DataInputStream input = new DataInputStream(in);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line = "";
		line = br.readLine();
		int numberOfCases = Integer.parseInt(line);
		FileOutputStream out = null;
		out = new FileOutputStream("out.txt");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		for(int i =0;i<numberOfCases;i++){
			int n = Integer.parseInt(br.readLine());
			int[] heights = new int[2501];
			for(int j=0;j<2*(n)-1;j++){
				line = br.readLine();
				//System.out.println(line);
				String[] intsString = line.split(" ");
				//System.out.println(line);
				for(int k=0;k<intsString.length;k++){
					heights[Integer.parseInt(intsString[k])]+=1;
				}
			}
			String answer = "";
			for(int j=0;j<2501;j++){
				if(heights[j]%2!=0){
					answer += j+" ";
				}
			}
			
			
			bw.write("Case #"+(i+1)+": "+answer+"\n");
		}
		br.close();
		bw.close();
	}
}
