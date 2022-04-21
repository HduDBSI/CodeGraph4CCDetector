package googlejam3.p501;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;


public class Battleship{

	public static void main (String[] args) throws FileNotFoundException{
		File f1 = new File("1C-Ain");
		File f2 = new File("1C-Aout");
		//Scanner read = new Scanner(f);
		Scanner read = new Scanner(f1);
		PrintWriter write = new PrintWriter(f2);
		int limit = read.nextInt();
		for (int l = 1; l <= limit; l++){
			//System.out.println(l);
			int r = read.nextInt();
			int c = read.nextInt();
			int w = read.nextInt();
			int total = w;
			//int rtot = (r - 1) / w;
			//int ctot = (c - 1) / w;
			//System.out.println((r - 1) / w);
			//System.out.println((c - 1) / w);
			total += (c - 1) / w * r;
			if (w == 1) total = r * c;
			write.println("Case #" + l + ": " + total);
		}
		write.close();
	}
}
