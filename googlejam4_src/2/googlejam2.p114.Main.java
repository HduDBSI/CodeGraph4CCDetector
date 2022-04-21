package googlejam2.p114;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

public class Main
{

	public static void main(String[] args) throws IOException
	{
		Main main = new Main();
		// streams
		String inputFileName = "C:\\Users\\ahmed\\Desktop\\Codejam\\Input.in";
		String outputFileName = "C:\\Users\\ahmed\\Desktop\\Codejam\\Output.txt";
		main.in = new BufferedReader(new FileReader(inputFileName));
		main.out = new BufferedWriter(new FileWriter(outputFileName));
		main.ans = new StringBuilder();
		
		// precompute
		int n = 1000009;
		main.dist = new int[n];
		main.visited = new boolean[n];
		main.dist[1] = 1;
		main.visited[1] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		Queue<Integer> d = new LinkedList<Integer>();
		q.add(1);
		d.add(1);
		while (!q.isEmpty())
		{
			int x1 = q.poll();
			int distance = d.poll();
			int next1 = x1 + 1;
			if (next1 < n)
				if (!main.visited[next1])
				{
					main.visited[next1] = true;
					main.dist[next1] = distance + 1;
					q.add(next1);
					d.add(distance + 1);
				}
			StringBuilder strb = new StringBuilder(x1 + "");
			int next2 = Integer.parseInt(strb.reverse().toString());
			if (next2 < n)
				if (!main.visited[next2])
				{
					main.visited[next2] = true;
					main.dist[next2] = distance + 1;
					q.add(next2);
					d.add(distance + 1);
				}
		
		}
		
		// read cases
		int nCases = Integer.parseInt(main.in.readLine());
		for (int cas = 1; cas <= nCases; cas++)
		{
			int x = Integer.parseInt(main.in.readLine().trim());
			
			// solve
			main.ans.append("Case #" + cas + ": " + main.dist[x] + "\n");
		}
		
		// output
		System.out.print(main.ans.toString());
		main.out.write(main.ans.toString());
		main.out.flush();
		main.out.close();
	}

	/* IO */
	private StringBuilder ans;
	private BufferedReader in;
	private BufferedWriter out;
	private StringTokenizer tok;
	private int[] dist;
	private boolean[] visited;

	/* fields */
}
