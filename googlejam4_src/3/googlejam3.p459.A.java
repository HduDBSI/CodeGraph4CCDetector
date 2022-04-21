package googlejam3.p459;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class A {

	public static void main(String[] args) throws Exception {
//        Scanner sc = new Scanner(new FileReader("data/sample"));
        Scanner sc = new Scanner(new FileReader("data/A-small-attempt0.in"));
//        Scanner sc = new Scanner(new FileReader("data/A-large.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("data/out"));
        int caseCount = sc.nextInt();
        for(int caseNum = 0; caseNum < caseCount; caseNum++) {
        	pw.print("Case #" + (caseNum + 1) + ": ");
        	System.out.print("Case #" + (caseNum + 1) + ": ");

        	A template = new A();
        	int R, C, W;
					R = sc.nextInt();
					C = sc.nextInt();
					W = sc.nextInt();
					
					int fh = R * C / W;
					int ans = 0;
					
					boolean edge;
					if(C % W == 0) {
						edge = true;
					} else {
						edge = false;
					}
					
					if(edge) {
						ans = fh + W - 1;
					} else {
						ans = fh + W;
					}
					
					System.out.print(ans);
					pw.print(ans);
			//		System.out.println(R + " " + C + " " + W);
        	
        	System.out.println();
        	pw.println();
        }
        
        pw.flush();
        pw.close();
        sc.close();
	}

}
