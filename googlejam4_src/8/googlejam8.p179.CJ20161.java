package googlejam8.p179;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;


public class CJ20161 {

	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new File("input.txt"));
		PrintWriter file = new PrintWriter(new File("output.txt"));
		
		int[] alf = new int[26];
		int a = (int)'A';
		int n;
		int max1, ind1;
		int max2, ind2;
		int Q = sc.nextInt();
		for(int t=0; t< Q; ++t){
			System.out.print("Case #" + (t+1) + ": ");
			file.print("Case #" + (t+1) + ": ");
		max1 = 0;
		ind1 = 0;
		max2 = 0;
		ind2 = 0;
		for(int i=0; i<26; ++i){
			alf[i] = 0;
		}
		n = sc.nextInt();
		
		for(int i=0; i<n; ++i){
			alf[i] = sc.nextInt();
		}
		for(int i=0; i<n; ++i){
			if(alf[i] > max1){
				max1 = alf[i];
				ind1 = i;
			}
		}
		for(int i=0; i<n; ++i){
			if(alf[i] > max2 && ind1 != i){
				max2 = alf[i];
				ind2 = i;
			}
		}
		//System.out.println(max1 + " " + max2);
		
		for(int i=max1; i>max2; --i){
			System.out.print((char)(a + ind1) + " ");
			file.print((char)(a + ind1) + " ");
		}
		
		
		for(int i=0; i < n ; ++ i){
			if(i != ind1 && i != ind2){
				for(int k=0; k<alf[i]; ++k){
					System.out.print((char)(a + i) + " ");
					file.print((char)(a + i) + " ");
				}
			}
		}
		
		for(int i=max2; i>0; --i){
			System.out.print((char)(a + ind1) + "" + (char)(a + ind2) + " ");
			file.print((char)(a + ind1) + "" + (char)(a + ind2) + " ");
		}
		System.out.println();
		file.println();
		}
		file.close();
	}
}
