package googlejam1.p370;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class A{
	public static void main(String args[]){
		String inputFileName = "A-large.in";
		String outputFileName = "A-large.out";
		try{
			Scanner scan = new Scanner(new FileInputStream(inputFileName));
			PrintWriter printer = new PrintWriter(new FileOutputStream(outputFileName));
			int T = scan.nextInt();
			scan.nextLine();
			for(int t = 0; t < T; t++){
				int N = scan.nextInt();
				int[] counts = new int[N];
				for(int i = 0; i < N; i++){
					counts[i] = scan.nextInt();
				}
				int count1 = 0;
				int maxDiff = 0;
				for(int i = 0; i < N -1; i++){
					int diff = Math.max(0,counts[i] - counts[i+1]); 
					count1 += diff;
					if(maxDiff < diff)
						maxDiff = diff;
				}
				int count2 = 0;
				for(int i = 0; i < N -1; i++){
					count2 += Math.min(counts[i],maxDiff);
				}
				printer.println("Case #"+(t+1)+": "+count1+" "+count2);
			}
			printer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}