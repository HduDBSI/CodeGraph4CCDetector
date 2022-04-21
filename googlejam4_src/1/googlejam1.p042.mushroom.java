package googlejam1.p042;
/*
ID: mkural31
LANG: JAVA
TASK: mushroom
*/
import java.io.*;
import java.util.*;

public class mushroom{
	public static void main (String [] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("mushroom.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mushroom.out")));
		int t = Integer.parseInt(f.readLine());
		for(int waka = 0;waka<t;waka++){
			StringTokenizer st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m[] = new int[n];
			StringTokenizer sc  = new StringTokenizer(f.readLine());
			System.out.println(n);
			for(int i = 0;i<n;i++){
				m[i]=Integer.parseInt(sc.nextToken());
				System.out.println("m[" + i + "] is " + m[i]);
			}
			int first = 0;
			int rate = 0;
			for(int i = 0;i<n-1;i++){
				first+=Math.max(0,m[i]-m[i+1]);
				if(m[i]>m[i+1]){
					rate=Math.max(rate,m[i]-m[i+1]);
				}
			}
			int second = 0;
			for(int i = 0;i<n-1;i++){
				if(rate>=m[i]){
					second +=m[i];
				}
				else{
					second+=rate;
				}
			}
			out.print("Case #" + (waka+1) + ": ");
			out.println(first + " " + second);
		}
		out.close();
		System.exit(0);
	}
}