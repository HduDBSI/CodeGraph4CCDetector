package googlejam7.p115;
import java.io.File;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;


public class B {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("B.in"));
		PrintWriter out = new PrintWriter(new File("B.out"));
		int T = sc.nextInt();
		for(int t=1;t<=T;t++){
			char[] A = sc.next().toCharArray();
			char[] B = sc.next().toCharArray();
			String AA = String.valueOf(A);
			String BB = String.valueOf(B);
			int delta = Integer.MAX_VALUE;
			
			for(int a=0;a<999;a++){
				char[] tempA = A.clone();
				if(tempA.length>0&&tempA[0]=='?'){
					tempA[0] = (char)('0' + ((a/100)%10));
				}
				if(tempA.length>1&&tempA[1]=='?'){
					tempA[1] = (char)('0' + ((a/10)%10));
				}
				if(tempA.length>2&&tempA[2]=='?'){
					tempA[2] = (char)('0' + (a%10));
				}
				for(int b=0;b<999;b++){
					char[] tempB = B.clone();
					if(tempB.length>0&&tempB[0]=='?'){
						tempB[0] = (char)('0' + ((b/100)%10));
					}
					if(tempB.length>1&&tempB[1]=='?'){
						tempB[1] = (char)('0' + ((b/10)%10));
					}
					if(tempB.length>2&&tempB[2]=='?'){
						tempB[2] = (char)('0' + (b%10));
					}
					
					int AAA = Integer.parseInt(String.valueOf(tempA));
					int BBB = Integer.parseInt(String.valueOf(tempB));
					int diff = Math.abs(AAA-BBB);
					if(diff<delta){
						delta=diff;
						AA=String.valueOf(tempA);
						BB=String.valueOf(tempB);
					}
				}
			}
			System.out.printf("Case #%d: %s %s%n",t,AA,BB);
			out.printf("Case #%d: %s %s%n",t,AA,BB);
		}
		
		out.close();
	}
}
