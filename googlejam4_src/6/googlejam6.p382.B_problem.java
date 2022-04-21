package googlejam6.p382;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class B_problem {
	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader(
				"/Users/SISQUAKE/workspace/code_jam/input/B-small-attempt0_1.in");

		BufferedReader br = new BufferedReader(fr);
		int n;

		n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			int N  = Integer.parseInt(br.readLine());
			int[][] m = new int[2*N-1][N];
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for(int j =0 ; j < 2*N-1 ; j++){
				String str = br.readLine();
				int k = 0 ;
				//l.add(Integer.parseInt(str.replaceAll(" ", "")));
				String[] s = str.split(" ");
				for(String st : s){
					int number = Integer.parseInt(st);
					if(map.containsKey(number)){
						int tmp = map.get(number);
						map.put(number, tmp+1);
					}else{
						map.put(number, 1);
					}
				}
			}
			ArrayList<Integer> l = new ArrayList<Integer>();
			for (Map.Entry<Integer, Integer> entry : map.entrySet())
			{
			    if(entry.getValue()%2!=0){
			    	l.add(entry.getKey());
			    }
			}
			
			Collections.sort(l);
			System.out.print("Case #"+i+": "+l.get(0));
			
			for(int k = 1 ; k < l.size() ; k ++ ){
				System.out.print(" "+l.get(k));
			}
			
			System.out.println("");
			
			

		}
		fr.close();

	}
}
