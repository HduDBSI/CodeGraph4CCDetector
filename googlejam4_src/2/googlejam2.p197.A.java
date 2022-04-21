package googlejam2.p197;
import java.util.*;
import java.io.*;

public class A {
	static PrintWriter pw;
	public static void main(String args[]) throws Exception{
		BufferedReader input = new BufferedReader(new FileReader("../GoogleCodeJam2015R1B/io/A-small-attempt0.in"));
		pw = new PrintWriter(new FileWriter("../GoogleCodeJam2015R1B/io/output.txt"));
		
		int[] numsper = new int[1000001];
		for(int j = 0 ; j <= 1000000 ; j ++){
			numsper[j] = Integer.MAX_VALUE;
		}
		numsper[0] = 0;
		Queue<String> q = new LinkedList<String>();
		q.add("0,0");
		while(!q.isEmpty()){
			String[] s = q.poll().split(",");
			int num = Integer.parseInt(s[0]);
			int turn = Integer.parseInt(s[1]);
			if((num + 1) >= 1000001)continue;
			
			if(numsper[num + 1] > (turn + 1)){
				numsper[num + 1] = turn + 1;
				q.add((num + 1)+","+(turn + 1));
			}
			StringBuilder sb = new StringBuilder();
			sb.append(s[0]);
			int revnum = Integer.parseInt(sb.reverse().toString());
			if(numsper[revnum] > (turn + 1)){
				numsper[revnum] = turn + 1;
				q.add((revnum)+","+(turn + 1));
			}
		}
		
		
		int T = Integer.parseInt(input.readLine());
		for(int i = 0 ; i < T ; i++){
			int N = Integer.parseInt(input.readLine());
			pw.println("Case #"+(i+1)+": "+numsper[N]);
		}
		pw.flush();
		input.close();
		pw.close();
	}
}
