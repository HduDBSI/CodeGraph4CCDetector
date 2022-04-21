package googlejam1.p804;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * FileName: Main.java
 * @Description:
 *
 * @author Xunhu(Tiger) Sun
 *         email: sunx2013@my.fit.edu
 * @date Apr 10, 2015 8:05:22 PM
 */
public class Main {
    final Scanner sc = new Scanner(System.in);

    int n;
    int[] a;

    public static void main (String[] args) {
        Main r = new Main();
		final int cn = r.sc.nextInt();
		r.sc.nextLine();
		for (int ci = 1; ci <= cn; ci++) {
		    r.n = r.sc.nextInt();
			r.sc.nextLine();
			r.a = new int[r.n];
			for(int i = 0; i < r.n; i++){
			    r.a[i] = r.sc.nextInt();
			}
			r.sc.nextLine();
		    System.out.printf("Case #%d: ", ci);
		    int sumrd =0;
			int maxrd = 0;
			for(int i = 1; i < r.n; i++){
			    if(r.a[i] < r.a[i-1]){
			        int rd = r.a[i-1]-r.a[i];
			        sumrd+=rd;
			        if(maxrd< rd){
			            maxrd=rd;
			        }
			    }
			}
			int sum2 = 0;
			for(int i = 0; i < r.n-1; i++){
			    int p = r.a[i];
			    if(p < maxrd){
			        sum2+=p;
			    } else{
			        sum2+=maxrd;
			    }
			}
			System.out.println(sumrd+" "+sum2);
		}
    }
}
