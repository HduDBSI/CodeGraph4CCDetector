package googlejam3.p225;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("c:\\codejam2015\\a\\small.in"));
		PrintWriter out = new PrintWriter(new File(
				"c:\\codejam2015\\a\\small.out"));
		int numTests = in.nextInt();
		for (int i = 1; i <= numTests; i++) {
			long start = System.currentTimeMillis();
					
					int r = in.nextInt();
					int c = in.nextInt();
					int w = in.nextInt();
					
					
					System.out.println("solving = " + r + ", " + c + ", " + w);
					solved = new boolean[c];
					Arrays.fill(solved, false);
					
			//		int maxStart = 0;
			//		int maxEnd = c -1;
			//		int max = c;
					
					Queue<int[]> q = new LinkedList<int[]>();
			//		
					q.offer(new int[]{0, c-1});
			//		
					int numHits = 0;
					
					int max = c;
					
					while(max > w) {
						numHits ++;
						max = max - w;
					}
					
					numHits = numHits * r;
					if(max == w) {
						numHits = numHits + (r -1);
					}
					numHits = numHits + w;
					
			//		while(!q.isEmpty()) {
			//			numHits++;
			//			
			//			int[] maxMarkers = q.poll();
			//			int maxStart = maxMarkers[0];
			//			int maxEnd = maxMarkers[1];
			//			int marked = (maxStart + maxEnd) / 2;
			//			solved[marked] = true;
			//			if((maxEnd - marked) >= w) {
			//				q.offer(new int[]{marked + 1, maxEnd});
			//			}
			//			if((marked - maxStart) >= w) {
			//				q.offer(new int[]{maxStart, marked - 1});
			//			}
			//			if(q.isEmpty()) {
			//				int max = (maxEnd - maxStart) + 1;
			//				if(max > w) {
			//					numHits += w;
			//				} else {
			//					numHits += (w -1);
			//				}
			//			}
			//		}
					
			//		
			//		if(w == 1) {
			//			numHits = c;
			//		} else {
			//		while(max >= w) {
			//			int marked = (maxStart + maxEnd) / 2;
			//			System.out.println("marking " + marked);
			//			solved[marked] = true;
			//			numHits++;
			//			
			//			int[] newMax = findMax();
			//			System.out.println("max " + Arrays.toString(newMax));
			//			if(newMax[1] > w) {
			//				max = newMax[1];
			//				maxStart = newMax[0];
			//				maxEnd = newMax[1] -1;
			//			} else {
			//				if(max > w) {
			//					numHits += w;
			//				} else {
			//					numHits += (w - 1);
			//				}
			//				break;
			//			}
			//		}
			//		}
					System.out.println("numHits " + numHits);
			
					out.println("Case #" + i + ": " + numHits);
		}

		out.close();
	}

	static boolean[] solved;


}
