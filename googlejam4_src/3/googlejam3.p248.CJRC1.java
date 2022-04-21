package googlejam3.p248;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class CJRC1 {

	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new File("input.txt"));
		PrintWriter pw = new PrintWriter("OUTPUT.TXT");
		int T = sc.nextInt();
		int r,c,w,rez;
		for(int t=0; t<T; ++t){
			r = sc.nextInt();
			c =sc.nextInt();
			w = sc.nextInt();
			rez = c/w;
			rez *=r;
			rez +=w-1;
			if(c%w > 0)
				rez+=1;
			pw.println("Case #" + (t+1) + ": " + rez );
		}
		pw.close();
	}
	
}
