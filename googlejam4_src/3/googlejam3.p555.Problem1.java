package googlejam3.p555;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Problem1 {

	public static void main(String[] args) throws IOException {
	Scanner scan = new Scanner(System.in);
	BufferedWriter out = new BufferedWriter(new FileWriter("out.txt"));
	int T = scan.nextInt();
	for(int i11=1;i11<=T;i11++){
		int r = scan.nextInt(),c=scan.nextInt(),w=scan.nextInt();
		out.write("Case #"+i11+": "+getAns(r,c,w)+"\n");
	}
	scan.close();
	out.close();}

	private static int getAns(int a, int c, int w) {
		int firstHit = 1+(int)(c-1)/w;
		return firstHit+w-1;
	}

}
