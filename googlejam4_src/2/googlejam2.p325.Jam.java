package googlejam2.p325;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;


public class Jam {

	public static void main(String[] args) throws IOException{
		FileReader in = new FileReader("src/A-small-attempt1.in");
		BufferedReader br = new BufferedReader(in);
		int T = Integer.parseInt(br.readLine());
				 
		File file = new File("src/output.txt");

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);		
		for(int i = 0; i < T; i++){
			int N = Integer.parseInt(br.readLine());
			int[] table = new int[N+1];
			table[1] = 1;
			table[0] = 0;
			for(int j = 1; j <= N; j++){
				int n = j;
				int reversed = 0;
				while(n != 0){
					reversed = reversed * 10 + n%10;
					n = n/10;
				}
				int rev = reversed;
				int n1 = table[j-1]+1;
				int n2 = Integer.MAX_VALUE-1;
				if(rev < j && Integer.toString(rev).length() == Integer.toString(j).length()){
					n2 = table[rev];
				}
				table[j] = Math.min(n1, n2+1);
			}
			bw.write("Case #" + Integer.toString(i+1)+": "+Integer.toString(table[N]));
			bw.newLine();
		}
		in.close();
		bw.close();
	}
	
}
