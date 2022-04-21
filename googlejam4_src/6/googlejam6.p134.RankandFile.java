package googlejam6.p134;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class RankandFile {
	public static void main(String[] args) throws FileNotFoundException {
		System.setOut(new PrintStream(new File("ans2.txt")));
		Scanner a=new Scanner(new BufferedInputStream(new FileInputStream("2.txt")));
		int caseNum=a.nextInt();
		for (int i=1;i<=caseNum;i++) {
			int n=a.nextInt();
			System.out.print("Case #"+i+": ");
			HashMap<Integer,Integer> myMap=new HashMap<Integer,Integer>();
			for (int j=0;j<2*n-1;j++) {
				for (int k=0;k<n;k++) {
					int s=a.nextInt();
					if (myMap.containsKey(s)) {
						myMap.put(s, myMap.get(s)+1);
					} else {
						myMap.put(s,1);
					}
				}
			}
			ArrayList<Integer> b=new ArrayList<Integer>();
			for (Integer p:myMap.keySet()) {
				//System.out.println(p+" "+myMap.get(p));

				if (myMap.get(p) % 2!=0) {
					b.add(p);
				}
			}
			Collections.sort(b);
			for (int k=0;k<b.size();k++) {
				System.out.print(b.get(k)+" ");

			}
			System.out.println();
		}
	}
}
