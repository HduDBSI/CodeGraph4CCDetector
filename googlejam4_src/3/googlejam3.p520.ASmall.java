package googlejam3.p520;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ASmall {
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new FileReader("A-small-attempt1.in"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("A-small-attempt1.out"));
		
		String line = in.readLine();
		int n = Integer.parseInt(line);
		for(int i=0; i<n; i++){
			line = in.readLine();
			String[] arr = line.split(" ");
			int r = Integer.parseInt(arr[0]);
			int c = Integer.parseInt(arr[1]);
			int w = Integer.parseInt(arr[2]);
			long min = 0;
			
			for(int x = 0; x < r-1; x++){
				min = min + (c/w);
			}
			if(c-w == 0){
				min = min + w;
			}else if(c-w < w){
				min = w + 1;
			}else{
				min = (long) (min + Math.ceil((double)c/(double)w));
				min = min + w - 1;
			}
			System.out.println("Case #"+(i+1)+": "+min+"\n");
			writer.write("Case #"+(i+1)+": "+min+"\n");
		}
		in.close();
		writer.close();
	}
}
