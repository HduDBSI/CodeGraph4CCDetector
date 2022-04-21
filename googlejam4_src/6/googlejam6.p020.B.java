package googlejam6.p020;
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

public class B {

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
			B r = new B();
			int n = Integer.parseInt(B.nextToken());
			int MAX = 2500;
			boolean[] bs = new boolean[MAX+1];
			for(int i =0; i < 2*n - 1;i++) {
				int[] ret1 = new int[n];
				for (int i1 = 0; i1 < n; i1++)
					ret1[i1] = Integer.parseInt(B.nextToken());
				int[] arr = ret1;
				for(int a : arr)
					bs[a] = !bs[a];
			}
			List<Integer> ret = new ArrayList<>();
			for(int i = 1; i<bs.length;i++){
				if(bs[i])
					ret.add(i);
			}
			StringBuilder str = new StringBuilder();
			for(int i =0;i<ret.size();i++){
				if(i !=0)
					str.append(" ");
				str.append(ret.get(i));
			}
			Object o = str;

			out.println("Case #" + casito + ": " + o);
			System.out.println("Case #" + casito + ": " + o);
		}
		out.close();
	}

	public static BufferedReader in;
	public static PrintWriter out;
	static String name_class = "B"; //
	static String loc = "/home/miguel/workspace/CodeJam/1A2016/src"; //

	static StringTokenizer strTok = new StringTokenizer("");

	static String nextToken() throws IOException {
		while (!strTok.hasMoreTokens())
			strTok = new StringTokenizer(in.readLine());
		return strTok.nextToken();
	}

}