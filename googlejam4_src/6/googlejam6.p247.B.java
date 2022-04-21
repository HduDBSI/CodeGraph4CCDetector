package googlejam6.p247;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class B {
	public static void main(String args[])throws IOException{
		Scanner scan = new Scanner(new File("B.txt"));
		PrintWriter pw = new PrintWriter("B.out");
		int cases = scan.nextInt();
		for(int i =1; i <= cases; i++){
			int N = scan.nextInt();
			int[] totals = new int[10_000];
			for(int z = 0; z < N*2-1; z++){
				for(int l = 0; l < N; l++){
					totals[scan.nextInt()]++;
				}
			}
			ArrayList<Integer>answers = new ArrayList<Integer>();
			for(int z = 0; z < totals.length; z++){
				if(totals[z]%2==1){
					answers.add(z);
				}
			}
			pw.print("Case #"+i+": ");
			for(Integer z : answers){
				pw.print(z+" ");
			}
			pw.println();
		}
		pw.close();
	}
}
