package googlejam1.p177;


import java.io.*;
import java.util.*;

import static java.lang.Math.*;
import static java.lang.Integer.*;

public class A {
	static Scanner sc = null;
	static BufferedReader br = null;
	static PrintWriter out = null;
	static PrintStream sysout = System.out;
	static Random rnd = new Random();
	
	int INF = Integer.MAX_VALUE / 10;
	double DF = 0.0000000001;
	
	long b = 1;
	int N = 0;
	int M = 0;
	

	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		File file = new File("A-large.in");
		if(file.exists()){
			System.setIn(new BufferedInputStream(new FileInputStream(file)));
		}
		else{
			throw new Exception("can't find a input file : " + file.getAbsolutePath());
		}
		//sc =  new Scanner(System.in);
		br = new BufferedReader(new InputStreamReader(System.in));
		FileWriter fw = new FileWriter(new File("output.txt"));
		out = new PrintWriter(fw);
		
		A b = new A();
		int T = 0;
		if(sc != null){
			T = sc.nextInt();
		}
		else{
			T = parseInt(br.readLine());
		}
		int t = 1;
		while(t <= T){
			out.print("Case #" + t + ": ");
			System.out.print("Case #" + t + ": ");
			String s = A.br.readLine();
			int N = Integer.parseInt(s);
			
			int[] d = new int[N];
			s = A.br.readLine();
			String[] sp = s.split(" ");
			for(int i = 0; i < N; i++){
				d[i] = Integer.parseInt(sp[i]);
			}
			int A1 = 0;
			int A2 = 0;
			for(int i = 0; i < N-1; i++){
				if(d[i] > d[i+1]){
					A1 += d[i] - d[i+1];
					A2 = Math.max(d[i] - d[i+1], A2);
				}
				
			}
			
			
			long ans = 0;
			for(int i = 0; i < N-1; i++){
				if(d[i] < A2){
					ans += d[i];
				}
				else{
					ans += A2;
				}
			}
			String s1 = A1 + " " + ans;
			A.out.println(s1);
			System.out.println(s1);
			t++;
		}
		out.close();
		fw.close();
	}
}
