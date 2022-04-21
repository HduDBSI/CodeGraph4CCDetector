package googlejam1.p354;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class A {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("A-large.in");
		Scanner stdin = new Scanner(file);
		int numCases = stdin.nextInt();
		for(int i = 1; i<=numCases; i++){
			int numSessions = stdin.nextInt();
			int m1Sum = 0;
			int previous = 0;
			int bigDiff = 0;
			int[] mushrooms = new int[numSessions];
			for(int k = 0; k<numSessions; k++){
				int current = stdin.nextInt();
				mushrooms[k] = current;
				if(current<previous){
					if(previous-current>bigDiff){
						bigDiff = previous-current;
					}
					m1Sum += previous-current;
				}
				previous = current;
			}
			int m2Sum = 0;
			for(int k=0; k<numSessions-1; k++){
				int current = mushrooms[k];
				if(current>bigDiff){
					m2Sum += bigDiff;
				}
				else{
					m2Sum += current;
				}
			}
			System.out.println("Case #"+i+": "+m1Sum+" "+m2Sum);
		}
	}
}