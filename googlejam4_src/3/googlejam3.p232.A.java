package googlejam3.p232;
import java.util.Scanner;


public class A {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int testCases = reader.nextInt();
		for(int t = 0; t < testCases; t++){
			int r = reader.nextInt();
			int c = reader.nextInt();
			int w = reader.nextInt();
			int answer = c / w;
			answer *= r;
			answer += w - 1;
			if(c % w > 0){
				answer++;
			}
			System.out.println("Case #" + (t+1) + ": " + answer);
		}
		reader.close();
	}

}
