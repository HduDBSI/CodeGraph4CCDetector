package googlejam8.p035;


import java.util.Scanner;

class A {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int T = scanner.nextInt();
    scanner.nextLine();
    for (int t = 1; t <= T; t++) {
      // TODO
	int N = scanner.nextInt();
	int senators[] = new int[N];
	
	int top1 = 0;
	int top1C = 0;
	int top2 = 0;
	int top2C = 0;
	int count = 0;
	for (int i = 0; i < N; i++) {
	  senators[i] = scanner.nextInt();
	  count += senators[i];
	
	  if (senators[i] > top1C) {
	
	    if (top1C > top2C) {
	      top2 = top1;
	      top2C = top1C;
	    }
	
	    top1 = i;
	    top1C = senators[i];
	
	  } else if (senators[i]> top2C) {
	    top2 = i;
	    top2C = senators[i];
	  }
	}
	
	System.out.printf("Case #%d:", t);
	while (top1C > top2C) {
	  char t11 = (char)('A' + top1);
	  if (top1C - top2C >= 2) {
	    System.out.print(" " + t11 + t11);
	    top1C -= 2;
	  } else {
	    System.out.print(" " + t11);
	    top1C -= 1;
	  }
	}
	
	for (int i = 0; i < N; i++) {
	  if (i != top1 && i != top2) {
	    char t1 = (char)('A' + i);
	    while (senators[i] > 0) {
	      if (senators[i] >= 2) {
	        System.out.print(" " + t1 + t1);
	        senators[i] -= 2;
	      } else {
	        System.out.print(" " + t1);
	        senators[i] -= 1;
	      }
	    }
	  }
	}
	
	while (top1C > 0) {
	  char t1 = (char)('A' + top1);
	  char t2 = (char)('A' + top2);
	  System.out.print(" " + t1 + t2);
	  top1C -= 1;
	}
	
	System.out.print("\n");
    }
  }
}