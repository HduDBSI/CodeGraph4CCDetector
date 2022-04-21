package googlejam4.p203;
import java.io.*;
import java.util.*;
import java.math.*;

public class Pegman {
	static int c;
	static char[][] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("in.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("out.out"));
		int t = Integer.parseInt(br.readLine());
		for(c = 1; c <= t; c++){
			bw.write("Case #" + c + ": ");
			String line = br.readLine();
			String[] fields = line.split(" ");
			int r = Integer.parseInt(fields[0]);
			int c = Integer.parseInt(fields[1]);
			arr = new char[r][c];
			for(int i = 0; i < r; i++){
				line = br.readLine();
				for(int j = 0; j < c; j++){
					arr[i][j] = line.charAt(j);
				}
			}
			boolean viable = true;
			int count = 0;
			for(int i = 0; i < r; i++){
				for(int j = 0; j < c; j++){
					if(arr[i][j] != '.'){
						boolean found = false;
						if(arr[i][j] == '>'){
							for(int k = j + 1; k < c; k++){
								if(arr[i][k] != '.'){
									found = true;
									break;
								}
							}
						}
						else if(arr[i][j] == '<'){
							for(int k = j - 1; k >= 0; k--){
								if(arr[i][k] != '.'){
									found = true;
									break;
								}
							}
						}
						else if(arr[i][j] == 'v'){
							for(int k = i + 1; k < r; k++){
								if(arr[k][j] != '.'){
									found = true;
									break;
								}
							}
						}
						else if(arr[i][j] == '^'){
							for(int k = i - 1; k >= 0; k--){
								if(arr[k][j] != '.'){
									found = true;
									break;
								}
							}
						}
						if(found){
							continue;
						}
						boolean works = false;
						for(int k = 0; k < r; k++){
							if(k == i) continue;
							if(arr[k][j] != '.'){
								works = true;
								break;
							}
						}
						for(int k = 0; k < c; k++){
							if(k == j) continue;
							if(arr[i][k] != '.'){
								works = true;
								break;
							}
						}
						if(works){
							count++;
						}
						else{
							viable = false;
							break;
						}
					}
				}
				if(!viable) break;
			}
			if(viable){
				bw.write(count + "\n");
			}
			else{
				bw.write("IMPOSSIBLE\n");
			}

		}
		br.close();
		bw.close();
	}









}