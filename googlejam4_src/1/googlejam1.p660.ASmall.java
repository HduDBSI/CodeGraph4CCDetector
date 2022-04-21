package googlejam1.p660;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ASmall {
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new FileReader("A-large.in"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("A-large.out"));
		
		String line = in.readLine();
		int n = Integer.parseInt(line);
		for(int i=0; i<n; i++){
			line = in.readLine();
			line = in.readLine();
			String[] arr = line.split(" ");
			int[] m = new int[arr.length];
			m[0] = Integer.parseInt(arr[0]);
			long min = 0;
			long minDiff = 0;
			for(int y=1; y<m.length; y++){
				m[y] = Integer.parseInt(arr[y]);
				if(m[y] < m[y-1]){
					min = min + (m[y-1] - m[y]);
				}
				if(m[y-1] - m[y] > minDiff){
					minDiff = m[y-1] - m[y];
				}
			}
			
			long min2 = 0;
			for(int y=0; y<m.length-1; y++){
				if(m[y] < minDiff){
					min2 = min2 + m[y];
				}else{
					min2 = min2 + minDiff;
				}
			}
			
			
			System.out.println("Case #"+(i+1)+": "+min+" "+min2+"\n");
			writer.write("Case #"+(i+1)+": "+min+" "+min2+"\n");
		}
		in.close();
		writer.close();
	}
}
