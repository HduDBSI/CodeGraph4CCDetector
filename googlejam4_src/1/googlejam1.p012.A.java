package googlejam1.p012;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class A {

	public static void main(String... args) throws Exception {
		File file = new File(loc);
		File[] paths = file.listFiles();
		List<File> input = new ArrayList<File>();
		for (File f : paths) {
			String s = f.getName();
			if (s.startsWith(name_class) && s.endsWith(".in"))
				input.add(f);
		}
		
		if (input.isEmpty()) {
			System.err.println("LEYENDO DE CONSOLA");
			in = new BufferedReader(new InputStreamReader(System.in));
		} else {
			File last_file = input.get(0);
			for (File f : input) {
				if (f.lastModified() > last_file.lastModified())
					last_file = f;
			}
		
			in = new BufferedReader(new FileReader(last_file.toString()));
			System.err.println("LEYENDO DE ARCHIVO");
		
		}
		FileWriter fw = new FileWriter(loc + "/output.txt");
		out = new PrintWriter(fw);

		int casos = Integer.parseInt(in.readLine());
		for (int casito = 1; casito <= casos; casito++) {
			A r = new A();
			int n = Integer.parseInt(A.nextToken());
			int[] ret = new int[n];
			for (int i1 = 0; i1 < n; i1++)
				ret[i1] = Integer.parseInt(A.nextToken());
			int[] arr = ret;
			int ret1 = 0;
			
			int abs =0;
			for(int i =0;i<n-1;i++){
				ret1+= Math.max(0, arr[i]-arr[i+1]);
				abs = Math.max(abs, arr[i]-arr[i+1]);
			}
			int ret2=0;
			for(int i =0;i<n -1;i++)
				ret2+=Math.min(arr[i], abs);
			Object o = ret1+" "+ret2;

			out.println("Case #" + casito + ": " + o);
			System.out.println("Case #" + casito + ": " + o);
		}
		out.close();
	}

	

	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static BufferedReader in;
	public static PrintWriter out;
	static String name_class = "A"; //
	static String loc = "/home/miguel/workspace/CodeJam/round_1A/src"; //

	static StringTokenizer strTok = new StringTokenizer("");

	static String nextToken() throws IOException {
		while (!strTok.hasMoreTokens())
			strTok = new StringTokenizer(in.readLine());
		return strTok.nextToken();
	}

}