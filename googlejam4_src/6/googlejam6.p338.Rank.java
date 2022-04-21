package googlejam6.p338;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Rank {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String inputFile = "B-large1.in";
		BufferedInputStream bs = new BufferedInputStream(new FileInputStream(inputFile));
		BufferedReader r = new BufferedReader(new InputStreamReader(bs, StandardCharsets.UTF_8));
		int t = Integer.parseInt(r.readLine());
		int count=1;
		String outputFile = "B-large_output1.txt";
		PrintWriter p = new PrintWriter(outputFile);
		
		while(t > 0) {
			int n = Integer.parseInt(r.readLine());
			Map<Integer,Integer> countMap = new HashMap<>();
			for(int i=0;i<2*n-1;i++) {
				
				String str[] = r.readLine().split(" ");
				for(int j=0;j<str.length;j++) {
					int num = Integer.parseInt(str[j]);
					if(countMap.get(num) == null) 
						countMap.put(num, 0);
					countMap.put(num, countMap.get(num)+1);
				}
			}
			List<Integer> l = new ArrayList<>();
			PriorityQueue<Integer> q = new PriorityQueue<>();
			for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
				if(entry.getValue()%2 == 1)
					l.add(entry.getKey());
			}
			Collections.sort(l);
			String ans = "";
			for(Integer num : l) {
				ans+= num + " ";
			}
			p.write("Case #"+count+": " + ans.substring(0,ans.length()-1)+"\n");
			t--;
			count++;
		}
		p.close();
		r.close();
	}

}
