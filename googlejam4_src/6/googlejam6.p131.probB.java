package googlejam6.p131;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;


public class probB {
	static  String input = "probB.in";
	static  String output = "probB.out";
	public static void main(String[] args) throws IOException{
//		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		BufferedReader in =new BufferedReader(new FileReader(input));
	PrintWriter out = new PrintWriter(new FileWriter(output));
		
		int t = Integer.parseInt(in.readLine());
		
		for(int i=1; i<=t; i++){
			out.print("Case #"+i+": ");
			int n = Integer.parseInt(in.readLine());
			HashMap<Integer, Integer> map = new HashMap<>();
			
			for(int i1=1; i1<n*2; i1++){
				StringTokenizer tok = new StringTokenizer(in.readLine());
				while(tok.hasMoreTokens()){
					int a = Integer.parseInt(tok.nextToken());
					if(map.containsKey(a)){
						map.put(a, map.get(a)+1);
					}	else {
						map.put(a, 1);
					}
				}
			}
			
			ArrayList<Integer> res = new ArrayList<>();
			
			Iterator<Integer> iter = map.keySet().iterator();
			while(iter.hasNext()){
				int height = iter.next();
				int count = map.get(height);
				
				if(count%2==1){
					res.add(height);
				}
			}
			
			Collections.sort(res);
			for(int a: res){
				out.print(a+" ");
			}
			
			if(res.size()!=n){
				System.out.println("error");
			}
			out.println();
		}
		out.flush();
	}
	
}
