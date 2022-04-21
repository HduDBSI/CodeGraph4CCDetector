package googlejam6.p324;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;


public class RankAndFile {

	static String smallIn = "small_input1AB.txt";
	static String largeIn = "large_input1AB.txt";
	static String smallOut = "small_output1AB.txt";
	static String largeOut = "large_output1AB.txt";
	public static void main(String[] args) {
		Path p = Paths.get(largeIn);
		try {
			Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(Files.newInputStream(p))));
			int test = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			for(int t = 1; t <= test; t++) {
				int N = sc.nextInt();
				int nums = N * N + N * (N - 1);
				HashMap<Integer, Integer> map = new HashMap();
				for(int i = 0; i < nums; i++) {
					int num = sc.nextInt();
					if(!map.containsKey(num)) {
						map.put(num, 1);
					} else {
						map.put(num, map.get(num) + 1);
					}
				}
				ArrayList<Integer> ret = new ArrayList();
				for(Integer i : map.keySet()) {
					if(map.get(i)%2 == 1) {
						ret.add(i);
					}
				}
				Collections.sort(ret);
				sb.append("Case #" + t +": ");
				for(int i = 0; i < ret.size(); i++) {
					sb.append(ret.get(i));
					if(i != ret.size() - 1) {
						sb.append(" ");
					}
				}
				if(t != test) {
					sb.append("\n");
				}
			}
			Path p1 = Paths.get(largeOut);
			try {
				Files.write(p1, sb.toString().getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
