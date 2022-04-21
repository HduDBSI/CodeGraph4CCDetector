package googlejam1.p282;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

class Mushrooms {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new FileReader(args[0]));
		PrintWriter out = new PrintWriter(args[1]);

		int numberOfCases = Integer.parseInt(in.readLine());
		for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
			int numIntervals = Integer.parseInt(in.readLine());
			String[] intervals = in.readLine().split(" ");

			int firstComp = 0;
			int secondComp = 0;
			int minRate = 0;

			int lastInterval = Integer.parseInt(intervals[0]);

			for (int i = 1; i < numIntervals; i++) {
				int thisInterval = Integer.parseInt(intervals[i]);
				int drop = lastInterval - thisInterval;
				if (drop > 0) firstComp += drop;
				minRate = Math.max(minRate, drop);
				lastInterval = thisInterval;
 			}

			System.out.println("Min: " + minRate);

			for (int i = 0; i < numIntervals-1; i++) {
				int interval = Integer.parseInt(intervals[i]);
				int eaten = interval - Math.max(0, interval - minRate);
				System.out.println(eaten);
				secondComp += eaten;
			}

			out.println(String.format("Case #%d: %d %d", caseNumber, firstComp, secondComp));
		}

		in.close();
		out.close();
	}
}