package googlejam6.p677;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class main {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new FileReader("/Users/yonggoo/Desktop/B-large.in"));
		FileWriter fw = new FileWriter("/Users/yonggoo/Desktop/1a_2_l.txt", true);
		int T = Integer.parseInt(bf.readLine());
		for(int i = 1; i <= T; i++){
			int N = Integer.parseInt(bf.readLine());
			List<Integer> result = new ArrayList<Integer>();
			for(int k = 1; k <= 2*N-1; k++)
				for(String val : bf.readLine().split(" "))
					result.add(Integer.parseInt(val));

			Set<Integer> unqResult = new HashSet<Integer>(result);
			String result_str = "";
			for(Integer v : unqResult)
				if(Collections.frequency(result, v)%2 == 1)
					result_str += " " + v;

			result_str = result_str.substring(1);
			String[] temp = result_str.split(" ");
			int[] real = new int[temp.length];
			for(int iii = 0; iii < temp.length; iii++)
				real[iii] = Integer.parseInt(temp[iii]);
				
			Arrays.sort(real);
			String result_go = "";
			for(int val : real){
				result_go += " " + val;
			}
			fw.write("Case #" + i + ":");
			fw.write(result_go);
			fw.write("\n");
		}
		fw.flush();
	}
}
