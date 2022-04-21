package googlejam1.p529;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ProblemA {
	public static void main(String[] args){
		try {
			String input = "C:\\Users\\Qin\\Desktop\\A-large.in";
			String output = "C:\\Users\\Qin\\Desktop\\A-large.out";
			FileInputStream fis= new FileInputStream(input);
			FileWriter fw = new FileWriter(output);
			Scanner sc = new Scanner(fis);
			
			int num = sc.nextInt();
			System.out.println(num);
			for(int i = 0; i < num; i++){
				int N = sc.nextInt();
				int[] M = new int[N];
				int m = 0, y = 0, z = 0;
				int max = 0;
				
				for(int j = 0; j < N; j++)
					M[j] = sc.nextInt();
		
				for(int j = 1; j < N; j++){
					if(M[j - 1] > M[j]){
						if((M[j - 1] - M[j]) > max)
							max = M[j - 1] - M[j];
						y = y + (M[j - 1] - M[j]);				
					}
				}
				
				for(int j = 0; j < N - 1; j++){
					if(M[j] <= max){
						z = z + M[j];
					}else{
						z = z + max;
					}
				}
				fw.write("Case #" + (i + 1) + ": " + y + " " + z + "\r\n");
				
			}
			fis.close();
			fw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
