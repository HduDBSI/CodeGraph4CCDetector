package googlejam9.p030;


import java.util.Scanner;

class B {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int T = scanner.nextInt();
    scanner.nextLine();
    for (int t = 1; t <= T; t++) {
      int B = scanner.nextInt();
	long M = scanner.nextLong();
	
	boolean pos = true;
	long max = 1;
	for (int i = 0; i < B - 2; i++) {
	  max = max * 2;
	}
	
	if (max < M) {
	  pos = false;
	}
	
	System.out.printf("Case #%d: %s\n", t, pos?"POSSIBLE":"IMPOSSIBLE");
	
	if (pos) {
	  int [][] matrix = new int[B][];
	  for (int i = 0; i < B; i++) {
	    matrix[i] = new int[B];
	  }
	
	  int use = B - 2;
	  while (max > M) {
	    max /= 2;
	    use --;
	  }
	
	  for (int i = 0; i <= use; i++) {
	    matrix[i][B-1] = 1;
	    for (int j = i + 1; j <= use; j++) {
	      matrix[i][j] = 1;
	    }
	  }
	
	  int next = use + 1;
	  long diff = M - max;
	  while (diff > 0) {
	    long link = 1;
	    int log = 0;
	    while (link * 2 <= diff) {
	      link *= 2;
	      log ++;
	    }
	
	    matrix[next][B-1] = 1;
	    matrix[log+1][next] = 1;
	    diff -= link;
	  }
	
	  for (int i = 0; i < B; i++) {
	    for (int j = 0; j < B; j++) {
	      System.out.print(matrix[i][j]);
	    }
	    System.out.print("\n");
	  }
	}
    }
  }
}