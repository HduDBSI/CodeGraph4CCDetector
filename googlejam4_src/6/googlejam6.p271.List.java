package googlejam6.p271;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class List {

	static StringTokenizer st;
	static BufferedReader sc;
	static PrintWriter pw;

	public static void main(String args[]) throws Exception {sc = new BufferedReader(new InputStreamReader(System.in));
	BufferedReader in = new BufferedReader(new FileReader("F:\\JAVA\\eclipse\\input.in")); 
	pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
			System.out)));
	String str;
	int [] a = new int [2510];
	String text = in.readLine(); 
	int T=Integer.parseInt(text); 	
	for (int tc=0;tc<T;tc++) {
		int n = Integer.parseInt(in.readLine()); 
		int[] out = new int[n];
		for (int i=0;i<2*n-1;i++) {
			text = in.readLine();
			String [] tmp = text.split(" ");
			for (int j=0;j<tmp.length;j++) {
				a[Integer.parseInt(tmp[j])]++;
			}			
		}
		int cnt = 0;
		for (int i=0;i<a.length;i++) {
			if (a[i]!=0) {
				if (a[i]%2==1) {
					out[cnt]=i;
					cnt++;
				}						
			}
		}
		Arrays.sort(out);
		String s = "";
		for (int i=0;i<out.length;i++) {
			s += Integer.toString(out[i])+ " ";
		}
		pw.println("Case #"+(tc+1)+": "+s.substring(0,s.length()-1));
	}
	//pw.println(arr.size());
	pw.close();

	}



}
