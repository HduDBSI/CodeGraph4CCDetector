package googlejam8.p277;
//package codejam.codejam2016.round1c;

import java.io.*;
import java.util.*;

public class A {
  static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  static final PrintStream out = System.out;

  public static void main(String[] args) {
    int T = scanner.nextInt();
    for (int t = 1; t <= T; t++) {
      out.print("Case #" + t + ": ");
      int N = scanner.nextInt();
	final int[] counts = new int[N];
	
	for (int i = 0 ; i < N; i++) {
	  counts[i] = scanner.nextInt();
	}
	
	PriorityQueue<Integer> pq = new PriorityQueue<>(N, new Comparator<Integer>() {
	  @Override
	  public int compare(Integer i1, Integer i2) {
	    return counts[i2] - counts[i1];
	  }
	});
	
	for (int i = 0; i < N; i++) {
	  pq.add(i);
	}
	
	while (!pq.isEmpty()) {
	  int p1 = pq.poll();
	
	  if (counts[p1] == 1 && pq.size() == 2) {
	    out.print((char) ('A' + p1));
	    out.print(' ');
	    counts[p1]--;
	    continue;
	  }
	
	  if (counts[pq.peek()] == counts[p1]) {
	    int p2 = pq.poll();
	    out.print((char) ('A' + p1));
	    out.print((char) ('A' + p2));
	    out.print(' ');
	
	    counts[p1]--;
	    counts[p2]--;
	
	    if (counts[p1] > 0) {
	      pq.add(p1);
	    }
	
	    if (counts[p2] > 0) {
	      pq.add(p2);
	    }
	  } else {
	    out.print((char) ('A' + p1));
	    out.print(' ');
	
	    counts[p1]--;
	
	    if (counts[p1] > 0) {
	      pq.add(p1);
	    }
	  }
	}
	
	out.println();
    }
  }
}
